package ktfx.generator.layouts

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.annotate
import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.buildFile
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecContainerScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.asClassName
import ktfx.generator.CONTRACT
import ktfx.generator.EXACTLY_ONCE
import ktfx.generator.EXPERIMENTAL_CONTRACTS
import ktfx.generator.KTFX_LAYOUTS
import ktfx.generator.LAYOUTS_DSL_MARKER
import ktfx.generator.NEW_CHILD
import ktfx.generator.OPT_IN
import java.io.File

object LayoutsGenerator {

    fun generate(entries: LayoutsEntries) {
        println("Generating to ${entries.path}:")
        entries.forEach { entry ->
            val filteredEntries = entries.filter { it.kClass == entry.kClass }
            val fileName = when (filteredEntries.size) {
                1 -> entry.generatedName
                else -> "${entry.generatedName}${filteredEntries.indexOf(entry)}"
            }
            println(fileName)
            buildFile(KTFX_LAYOUTS, fileName) {
                indentSize = 4
                annotations {
                    add<JvmMultifileClass>()
                    JvmName::class { addMember("%S", entries.className) }
                    OPT_IN { addMember("%T::class", EXPERIMENTAL_CONTRACTS) }
                }
                functions {
                    entry.managerClassNames.forEach { managerClassName ->
                        entry.functionName {
                            entry.typeVariableNames.forEach(::addTypeVariable)
                            receiver = managerClassName
                            kdoc += entry.getComment(add = true, styled = false, configured = false)
                            returns = entry.typeName
                            parameters {
                                entry.parameters.forEach(::add)
                            }
                            appendln(
                                "return ${entry.functionName}(${entry.getParameterName(
                                    namedArgument = true, commaSuffix = false
                                )}) { }"
                            )
                        }
                    }
                    entry.fullManagerClassNames.forEach { managerClassName ->
                        entry.functionName {
                            entry.typeVariableNames.forEach(::addTypeVariable)
                            if (managerClassName != null) receiver = managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc += entry.getComment(
                                add = managerClassName != null, styled = false, configured = true
                            )
                            returns = entry.typeName
                            parameters {
                                entry.parameters.forEach(::add)
                                configuration(entry)
                            }
                            contractln()
                            append("return ")
                            if (managerClassName != null) append("addChild(")
                            append(
                                "%M(%T(${entry.getParameterName(
                                    namedArgument = false, commaSuffix = false
                                )}), configuration = configuration)",
                                NEW_CHILD, entry.customTypeName
                            )
                            if (managerClassName != null) append(")")
                            appendln()
                        }
                    }
                    entry.fullManagerClassNames.forEach { managerClassName ->
                        entry.styledFunctionName {
                            entry.typeVariableNames.forEach(::addTypeVariable)
                            if (managerClassName != null) receiver = managerClassName
                            kdoc += entry.getComment(
                                add = managerClassName != null, styled = true, configured = false
                            )
                            returns = entry.typeName
                            parameters {
                                entry.parameters.forEach(::add)
                                styleClass()
                                id()
                            }
                            appendln(
                                "return ${entry.styledFunctionName}(${entry.getParameterName(
                                    namedArgument = true, commaSuffix = true
                                )}styleClass = *styleClass, id = id) { }"
                            )
                        }
                    }
                    entry.fullManagerClassNames.forEach { managerClassName ->
                        entry.styledFunctionName {
                            entry.typeVariableNames.forEach(::addTypeVariable)
                            if (managerClassName != null) receiver = managerClassName
                            addModifiers(KModifier.INLINE)
                            kdoc += entry.getComment(
                                add = managerClassName != null, styled = true, configured = true
                            )
                            returns = entry.typeName
                            parameters {
                                entry.parameters.forEach(::add)
                                styleClass()
                                id()
                                configuration(entry)
                            }
                            contractln()
                            append("return ")
                            if (managerClassName != null) append("addChild(")
                            append(
                                "%M(%T(${entry.getParameterName(
                                    namedArgument = false, commaSuffix = false
                                )}), styleClass = *styleClass, id = id, configuration = configuration)",
                                NEW_CHILD, entry.customTypeName
                            )
                            if (managerClassName != null) append(")")
                            appendln()
                        }
                    }
                }
            }.writeTo(File(entries.path))
        }
        println("Finished!")
    }

    private fun FunSpecBuilder.contractln() = appendln("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecContainerScope.styleClass() = add("styleClass", String::class, KModifier.VARARG)

    private fun ParameterSpecContainerScope.id() =
        add("id", String::class.asClassName().asNullable()) { defaultValue("null") }

    private fun ParameterSpecContainerScope.configuration(entry: LayoutsEntry) = add(
        "configuration", entry.customTypeName
            .annotate(LAYOUTS_DSL_MARKER)
            .lambdaBy(returnType = Unit::class.asClassName())
    )
}