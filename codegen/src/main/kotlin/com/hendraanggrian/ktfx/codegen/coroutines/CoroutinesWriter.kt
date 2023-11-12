package com.hendraanggrian.ktfx.codegen.coroutines

import com.hendraanggrian.kotlinpoet.annotation
import com.hendraanggrian.kotlinpoet.annotations
import com.hendraanggrian.kotlinpoet.buildFileSpec
import com.hendraanggrian.kotlinpoet.functions
import com.hendraanggrian.kotlinpoet.generics
import com.hendraanggrian.kotlinpoet.name
import com.hendraanggrian.kotlinpoet.parameters
import com.hendraanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.STAR
import java.io.File

object CoroutinesWriter {
    fun write(factory: ListenerFactory) {
        println("Generating to ${factory.path}:")
        factory.entries.forEach { classEntry ->
            val fileName = "_${classEntry.generatedName}"
            println(fileName)
            buildFileSpec(factory.packageName, fileName) {
                indentSize = 4
                annotations {
                    annotation<JvmMultifileClass>()
                    JvmName::class.name { member("%S", factory.className) }
                }
                classEntry.functions.forEach { functionEntry ->
                    functions {
                        functionEntry.simpleFunctionName {
                            kdoc(
                                "@see %T.${functionEntry.functionName}",
                                classEntry.kdocType,
                            )
                            receiver = classEntry.receiver

                            if (classEntry.receiver is ParameterizedTypeName) {
                                classEntry.receiver.typeArguments.filter { it != STAR }.forEach {
                                    typeVariable(it.toString().generics)
                                }
                            }

                            returns<Unit>()
                            if (factory.extraFunctionModifier != null) {
                                modifiers(factory.extraFunctionModifier)
                            }
                            parameters {
                                functionEntry.parameters.forEach(::parameter)
                            }

                            appendLine(
                                "return %L",
                                when ("coroutines") {
                                    !in factory.path ->
                                        "${functionEntry.functionName}(${
                                            parameters.toString(
                                                namedArgument = false,
                                                commaSuffix = false,
                                            )
                                        })"
                                    else ->
                                        buildString {
                                            val hasParam =
                                                (parameters.last().type as LambdaTypeName)
                                                    .parameters.isNotEmpty()
                                            append("${functionEntry.functionName} {")
                                            if (hasParam) {
                                                append(" event ->")
                                            }
                                            append(
                                                " GlobalScope.launch(context) { " +
                                                    "${parameters.last().name}(",
                                            )
                                            if (hasParam) {
                                                append("event")
                                            }
                                            append(") } }")
                                        }
                                },
                            )
                        }
                    }
                }
                factory.extraFileConfiguration(this)
            }.writeTo(File(factory.path))
        }
        println("Finished!")
        println()
    }
}
