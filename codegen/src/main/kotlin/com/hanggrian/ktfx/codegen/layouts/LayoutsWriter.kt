package com.hanggrian.ktfx.codegen.layouts

import com.hanggrian.kotlinpoet.FunSpecBuilder
import com.hanggrian.kotlinpoet.INLINE
import com.hanggrian.kotlinpoet.ParameterSpecHandlerScope
import com.hanggrian.kotlinpoet.VARARG
import com.hanggrian.kotlinpoet.add
import com.hanggrian.kotlinpoet.annotate
import com.hanggrian.kotlinpoet.annotationSpecOf
import com.hanggrian.kotlinpoet.buildFileSpec
import com.hanggrian.kotlinpoet.lambdaBy
import com.hanggrian.kotlinpoet.name
import com.hanggrian.kotlinpoet.nullable
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
                    add<JvmMultifileClass>()
                    JvmName::class.name { addMember("%S", factory.className) }
                    OPT_IN { addMember("%T::class", EXPERIMENTAL_CONTRACTS) }
                    Suppress::class.name { addMember("%S", "ktlint") }
                }
                functions {
                    entry.containerClassNames.forEach { containerClassName ->
                        entry.functionName {
                            entry.typeVarNames.forEach { typeVariables += it }
                            receiver = containerClassName
                            addModifiers(INLINE)
                            addKdoc(
                                entry.getFileComment(
                                    add = true,
                                    styled = false,
                                    configured = false,
                                ),
                            )
                            setReturns(
                                entry.typeName,
                                entry.getReturnsComment(add = true, styled = false),
                            )
                            parameters {
                                entry.parameters.forEach(::add)
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
                            addKdoc(
                                entry.getFileComment(
                                    add = containerClassName != null,
                                    styled = false,
                                    configured = true,
                                ),
                            )
                            setReturns(
                                entry.typeName,
                                entry.getReturnsComment(
                                    add = containerClassName != null,
                                    styled = false,
                                ),
                            )
                            parameters {
                                entry.parameters.forEach(::add)
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
                            addModifiers(INLINE)
                            addKdoc(
                                entry.getFileComment(
                                    add = containerClassName != null,
                                    styled = true,
                                    configured = false,
                                ),
                            )
                            setReturns(
                                entry.typeName,
                                entry.getReturnsComment(
                                    add = containerClassName != null,
                                    styled = true,
                                ),
                            )
                            parameters {
                                entry.parameters.forEach(::add)
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
                            addKdoc(
                                entry.getFileComment(
                                    add = containerClassName != null,
                                    styled = true,
                                    configured = true,
                                ),
                            )
                            setReturns(
                                entry.typeName,
                                entry.getReturnsComment(
                                    add = containerClassName != null,
                                    styled = true,
                                ),
                            )
                            parameters {
                                entry.parameters.forEach(::add)
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
        add("styleClass", String::class, VARARG) {
            addKdoc("the CSS style class.")
        }

    private fun ParameterSpecHandlerScope.id() =
        add("id", STRING.nullable()) {
            addKdoc("the CSS id.")
            setDefaultValue("null")
        }

    private fun ParameterSpecHandlerScope.configuration(entry: LayoutsEntry) =
        add(
            "configuration",
            entry.customTypeName
                .annotate(annotationSpecOf(DSL_MARKER))
                .lambdaBy(returns = UNIT),
        ) {
            addKdoc("the configuration block.")
        }
}
