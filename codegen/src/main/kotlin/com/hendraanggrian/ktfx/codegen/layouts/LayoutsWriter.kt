package com.hendraanggrian.ktfx.codegen.layouts

import com.hendraanggrian.kotlinpoet.FunSpecBuilder
import com.hendraanggrian.kotlinpoet.INLINE
import com.hendraanggrian.kotlinpoet.ParameterSpecHandlerScope
import com.hendraanggrian.kotlinpoet.VARARG
import com.hendraanggrian.kotlinpoet.annotate
import com.hendraanggrian.kotlinpoet.annotation
import com.hendraanggrian.kotlinpoet.annotations
import com.hendraanggrian.kotlinpoet.asAnnotationSpec
import com.hendraanggrian.kotlinpoet.buildFileSpec
import com.hendraanggrian.kotlinpoet.functions
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.hendraanggrian.kotlinpoet.name
import com.hendraanggrian.kotlinpoet.nullable
import com.hendraanggrian.kotlinpoet.parameter
import com.hendraanggrian.kotlinpoet.parameters
import com.hendraanggrian.ktfx.codegen.CONTRACT
import com.hendraanggrian.ktfx.codegen.DSL_MARKER
import com.hendraanggrian.ktfx.codegen.EXACTLY_ONCE
import com.hendraanggrian.ktfx.codegen.EXPERIMENTAL_CONTRACTS
import com.hendraanggrian.ktfx.codegen.OPT_IN
import com.hendraanggrian.ktfx.codegen.toString
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
                            modifiers(INLINE)
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
                    if (entry.supportStyledFunction) {
                        entry.fullContainerClassNames.forEach { containerClassName ->
                            entry.styledFunctionName {
                                entry.typeVarNames.forEach { typeVariables += it }
                                if (containerClassName != null) receiver = containerClassName
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
                                    }styleClass = *styleClass, id = id) { }",
                                )
                            }
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
                .annotate(DSL_MARKER.asAnnotationSpec())
                .lambdaBy(returns = UNIT),
        ) {
            kdoc("the configuration block.")
        }
}
