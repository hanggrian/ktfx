package ktfx.generator.layouts

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.annotate
import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.buildFileSpec
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecContainerScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.asClassName
import ktfx.generator.CONTRACT
import ktfx.generator.EXACTLY_ONCE
import ktfx.generator.EXPERIMENTAL_CONTRACTS
import ktfx.generator.LAYOUTS_DSL_MARKER
import ktfx.generator.NEW_CHILD
import ktfx.generator.OPT_IN
import java.io.File

object LayoutsWriter {

    fun write(factory: LayoutsFactory) {
        println("Generating to ${factory.path}:")
        factory.entries.forEach { entry ->
            val filteredEntries = factory.entries.filter { it.kClass == entry.kClass }
            val fileName = when (filteredEntries.size) {
                1 -> entry.generatedName
                else -> "${entry.generatedName}${filteredEntries.indexOf(entry)}"
            }
            println(fileName)
            buildFileSpec(factory.packageName, fileName) {
                indentSize = 4
                annotations {
                    add<JvmMultifileClass>()
                    JvmName::class { addMember("%S", factory.className) }
                    OPT_IN { addMember("%T::class", EXPERIMENTAL_CONTRACTS) }
                }
                functions {
                    entry.managerClassNames.forEach { managerClassName ->
                        entry.functionName {
                            entry.typeVarNames.forEach(::addTypeVariable)
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
                            entry.typeVarNames.forEach(::addTypeVariable)
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
                    if (entry.supportStyledFunction) {
                        entry.fullManagerClassNames.forEach { managerClassName ->
                            entry.styledFunctionName {
                                entry.typeVarNames.forEach(::addTypeVariable)
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
                                entry.typeVarNames.forEach(::addTypeVariable)
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
                }
            }.writeTo(File(factory.path))
        }
        println("Finished!")
    }

    private fun FunSpecBuilder.contractln() = appendln("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecContainerScope.styleClass() = add("styleClass", String::class, KModifier.VARARG)

    private fun ParameterSpecContainerScope.id() = add("id", String::class.asNullable()) { defaultValue("null") }

    private fun ParameterSpecContainerScope.configuration(entry: LayoutsEntry) = add(
        "configuration", Unit::class.asClassName()
            .lambdaBy(receiver = entry.customTypeName.annotate(LAYOUTS_DSL_MARKER))
    )
}