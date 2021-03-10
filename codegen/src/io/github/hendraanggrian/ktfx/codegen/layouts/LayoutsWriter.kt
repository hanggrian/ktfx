package io.github.hendraanggrian.ktfx.codegen.layouts

import io.github.hendraanggrian.kotlinpoet.FunSpecBuilder
import io.github.hendraanggrian.kotlinpoet.INLINE
import io.github.hendraanggrian.kotlinpoet.VARARG
import io.github.hendraanggrian.kotlinpoet.annotate
import io.github.hendraanggrian.kotlinpoet.asNullable
import io.github.hendraanggrian.kotlinpoet.buildFileSpec
import io.github.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import io.github.hendraanggrian.kotlinpoet.lambdaBy
import io.github.hendraanggrian.ktfx.codegen.CONTRACT
import io.github.hendraanggrian.ktfx.codegen.EXACTLY_ONCE
import io.github.hendraanggrian.ktfx.codegen.EXPERIMENTAL_CONTRACTS
import io.github.hendraanggrian.ktfx.codegen.DSL_MARKER
import io.github.hendraanggrian.ktfx.codegen.OPT_IN
import io.github.hendraanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.asClassName
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
                            entry.typeVarNames.forEach { typeVariables += it }
                            receiver = managerClassName
                            kdoc += entry.getFileComment(add = true, styled = false, configured = false)
                            returns(entry.typeName, entry.getReturnsComment(add = true, styled = false))
                            parameters {
                                entry.parameters.forEach(::plusAssign)
                            }
                            appendLine(
                                "return ${entry.functionName}(${entry.parameters.toString(
                                    namedArgument = true, commaSuffix = false
                                )}) { }"
                            )
                        }
                    }
                    entry.fullManagerClassNames.forEach { managerClassName ->
                        entry.functionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            if (managerClassName != null) receiver = managerClassName
                            addModifiers(INLINE)
                            kdoc += entry.getFileComment(
                                add = managerClassName != null, styled = false, configured = true
                            )
                            returns(
                                entry.typeName, entry.getReturnsComment(add = managerClassName != null, styled = false)
                            )
                            parameters {
                                entry.parameters.forEach(::plusAssign)
                                configuration(entry)
                            }
                            contractln()
                            appendLine(
                                "val child = %T(${entry.parameters.toString(
                                    namedArgument = false, commaSuffix = false
                                )})", entry.customTypeName
                            )
                            appendLine("child.configuration()")
                            appendLine {
                                append("return ")
                                if (managerClassName != null) append("addChild(")
                                append("child")
                                if (managerClassName != null) append(")")
                            }
                        }
                    }
                    if (entry.supportStyledFunction) {
                        entry.fullManagerClassNames.forEach { managerClassName ->
                            entry.styledFunctionName {
                                entry.typeVarNames.forEach { typeVariables += it }
                                if (managerClassName != null) receiver = managerClassName
                                kdoc += entry.getFileComment(
                                    add = managerClassName != null, styled = true, configured = false
                                )
                                returns(
                                    entry.typeName,
                                    entry.getReturnsComment(add = managerClassName != null, styled = true)
                                )
                                parameters {
                                    entry.parameters.forEach(::plusAssign)
                                    styleClass()
                                    id()
                                }
                                appendLine(
                                    "return ${entry.styledFunctionName}(${entry.parameters.toString(
                                        namedArgument = true, commaSuffix = true
                                    )}styleClass = *styleClass, id = id) { }"
                                )
                            }
                        }
                        entry.fullManagerClassNames.forEach { managerClassName ->
                            entry.styledFunctionName {
                                entry.typeVarNames.forEach { typeVariables += it }
                                if (managerClassName != null) receiver = managerClassName
                                addModifiers(INLINE)
                                kdoc += entry.getFileComment(
                                    add = managerClassName != null, styled = true, configured = true
                                )
                                returns(
                                    entry.typeName,
                                    entry.getReturnsComment(add = managerClassName != null, styled = true)
                                )
                                parameters {
                                    entry.parameters.forEach(::plusAssign)
                                    styleClass()
                                    id()
                                    configuration(entry)
                                }
                                contractln()
                                appendLine(
                                    "val child = %T(${entry.parameters.toString(
                                        namedArgument = false, commaSuffix = false
                                    )})", entry.customTypeName
                                )
                                appendLine("child.styleClass += styleClass")
                                appendLine("child.id = id")
                                appendLine("child.configuration()")
                                appendLine {
                                    append("return ")
                                    if (managerClassName != null) append("addChild(")
                                    append("child")
                                    if (managerClassName != null) append(")")
                                }
                            }
                        }
                    }
                }
            }.writeTo(File(factory.path))
        }
        println("Finished!")
        println()
    }

    private fun FunSpecBuilder.contractln() =
        appendLine("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecListScope.styleClass() = add("styleClass", String::class, VARARG) {
        kdoc.append("the CSS style class.")
    }

    private fun ParameterSpecListScope.id() = add("id", String::class.asNullable()) {
        kdoc.append("the CSS id.")
        defaultValue("null")
    }

    private fun ParameterSpecListScope.configuration(entry: LayoutsEntry) = add(
        "configuration", Unit::class.asClassName()
            .lambdaBy(receiver = entry.customTypeName.annotate(DSL_MARKER))
    ) {
        kdoc.append("the configuration block.")
    }
}