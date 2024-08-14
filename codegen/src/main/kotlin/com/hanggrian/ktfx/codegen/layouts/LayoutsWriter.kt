package com.hanggrian.ktfx.codegen.layouts

import com.hanggrian.kotlinpoet.FunSpecBuilder
import com.hanggrian.kotlinpoet.INLINE
import com.hanggrian.kotlinpoet.ParameterSpecHandlerScope
import com.hanggrian.kotlinpoet.VARARG
import com.hanggrian.kotlinpoet.annotate
import com.hanggrian.kotlinpoet.annotation
import com.hanggrian.kotlinpoet.annotationSpecOf
import com.hanggrian.kotlinpoet.annotations
import com.hanggrian.kotlinpoet.buildFileSpec
import com.hanggrian.kotlinpoet.functions
import com.hanggrian.kotlinpoet.lambdaBy
import com.hanggrian.kotlinpoet.name
import com.hanggrian.kotlinpoet.nullable
import com.hanggrian.kotlinpoet.parameter
import com.hanggrian.kotlinpoet.parameters
import com.hanggrian.ktfx.codegen.CONTRACT
import com.hanggrian.ktfx.codegen.DSL_MARKER
import com.hanggrian.ktfx.codegen.EXACTLY_ONCE
import com.hanggrian.ktfx.codegen.EXPERIMENTAL_CONTRACTS
import com.hanggrian.ktfx.codegen.OPT_IN
import com.hanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.STRING
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.buildCodeBlock
import java.io.File

object LayoutsWriter {
    fun write(factory: LayoutsFactory) {
        println("Generating to ${factory.path}:")
        factory.entries.forEach { entry ->
            val filteredEntries = factory.entries.filter { it.kClass == entry.kClass }
            val fileName =
                when (filteredEntries.size) {
                    1 -> entry.generatedName
                    else -> "${entry.generatedName}${filteredEntries.indexOf(entry)}"
                }
            println(fileName)
            buildFileSpec(factory.packageName, fileName) {
                indentSize = 4
                annotations {
                    annotation<JvmMultifileClass>()
                    JvmName::class.name { member("%S", factory.className) }
                    OPT_IN { member("%T::class", EXPERIMENTAL_CONTRACTS) }
                    Suppress::class.name { member("%S", "ktlint") }
                }
                functions {
                    entry.containerClassNames.forEach { containerClassName ->
                        entry.functionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            receiver = containerClassName
                            modifiers(INLINE)
                            kdoc(
                                entry.getFileComment(
                                    add = true,
                                    styled = false,
                                    configured = false,
                                ),
                            )
                            returns(
                                entry.typeName,
                                entry.getReturnsComment(add = true, styled = false),
                            )
                            parameters {
                                entry.parameters.forEach(::parameter)
                            }
                            appendLine(
                                "return ${entry.functionName}(${
                                    entry.parameters.toString(
                                        namedArgument = true,
                                        commaSuffix = false,
                                    )
                                }) { }",
                            )
                        }
                    }
                    entry.fullContainerClassNames.forEach { containerClassName ->
                        entry.functionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            if (containerClassName != null) receiver = containerClassName
                            kdoc(
                                entry.getFileComment(
                                    add = containerClassName != null,
                                    styled = false,
                                    configured = true,
                                ),
                            )
                            returns(
                                entry.typeName,
                                entry.getReturnsComment(
                                    add = containerClassName != null,
                                    styled = false,
                                ),
                            )
                            parameters {
                                entry.parameters.forEach(::parameter)
                                configuration(entry)
                            }
                            contractLine()
                            appendLine(
                                "val child = %T(${
                                    entry.parameters.toString(
                                        namedArgument = false,
                                        commaSuffix = false,
                                    )
                                })",
                                entry.customTypeName,
                            )
                            appendLine("child.configuration()")
                            appendLine(
                                buildCodeBlock {
                                    append("return ")
                                    if (containerClassName != null) append("addChild(")
                                    append("child")
                                    if (containerClassName != null) append(")")
                                },
                            )
                        }
                    }
                    if (!entry.isSupportStyledFunction) {
                        return@functions
                    }
                    entry.fullContainerClassNames.forEach { containerClassName ->
                        entry.styledFunctionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            if (containerClassName != null) receiver = containerClassName
                            modifiers(INLINE)
                            kdoc(
                                entry.getFileComment(
                                    add = containerClassName != null,
                                    styled = true,
                                    configured = false,
                                ),
                            )
                            returns(
                                entry.typeName,
                                entry.getReturnsComment(
                                    add = containerClassName != null,
                                    styled = true,
                                ),
                            )
                            parameters {
                                entry.parameters.forEach(::parameter)
                                styleClass()
                                id()
                            }
                            appendLine(
                                "return ${entry.styledFunctionName}(${
                                    entry.parameters.toString(
                                        namedArgument = true,
                                        commaSuffix = true,
                                    )
                                }styleClass = styleClass, id = id) { }",
                            )
                        }
                    }
                    entry.fullContainerClassNames.forEach { containerClassName ->
                        entry.styledFunctionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            if (containerClassName != null) receiver = containerClassName
                            kdoc(
                                entry.getFileComment(
                                    add = containerClassName != null,
                                    styled = true,
                                    configured = true,
                                ),
                            )
                            returns(
                                entry.typeName,
                                entry.getReturnsComment(
                                    add = containerClassName != null,
                                    styled = true,
                                ),
                            )
                            parameters {
                                entry.parameters.forEach(::parameter)
                                styleClass()
                                id()
                                configuration(entry)
                            }
                            contractLine()
                            appendLine(
                                "val child = %T(${
                                    entry.parameters.toString(
                                        namedArgument = false,
                                        commaSuffix = false,
                                    )
                                })",
                                entry.customTypeName,
                            )
                            appendLine("child.styleClass += styleClass")
                            appendLine("child.id = id")
                            appendLine("child.configuration()")
                            appendLine(
                                buildCodeBlock {
                                    append("return ")
                                    if (containerClassName != null) append("addChild(")
                                    append("child")
                                    if (containerClassName != null) append(")")
                                },
                            )
                        }
                    }
                }
            }.writeTo(File(factory.path))
        }
        println("Finished!")
        println()
    }

    private fun FunSpecBuilder.contractLine() =
        appendLine("%M { callsInPlace(configuration, %M) }", CONTRACT, EXACTLY_ONCE)

    private fun ParameterSpecHandlerScope.styleClass() =
        parameter("styleClass", String::class, VARARG) {
            kdoc("the CSS style class.")
        }

    private fun ParameterSpecHandlerScope.id() =
        parameter("id", STRING.nullable()) {
            kdoc("the CSS id.")
            defaultValue("null")
        }

    private fun ParameterSpecHandlerScope.configuration(entry: LayoutsEntry) =
        parameter(
            "configuration",
            entry.customTypeName
                .annotate(annotationSpecOf(DSL_MARKER))
                .lambdaBy(returns = UNIT),
        ) {
            kdoc("the configuration block.")
        }
}
