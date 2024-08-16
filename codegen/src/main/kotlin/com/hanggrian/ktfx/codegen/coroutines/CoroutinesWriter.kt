package com.hanggrian.ktfx.codegen.coroutines

import com.hanggrian.kotlinpoet.add
import com.hanggrian.kotlinpoet.buildFileSpec
import com.hanggrian.kotlinpoet.generics
import com.hanggrian.kotlinpoet.name
import com.hanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.STAR
import com.squareup.kotlinpoet.UNIT
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
                    add(JvmMultifileClass::class) {
                        useSiteTarget = AnnotationSpec.UseSiteTarget.FILE
                    }
                    JvmName::class.name {
                        addMember("%S", factory.className)
                        useSiteTarget = AnnotationSpec.UseSiteTarget.FILE
                    }
                }
                classEntry.functions.forEach { functionEntry ->
                    functions {
                        functionEntry.simpleFunctionName {
                            addKdoc(
                                "@see %T.${functionEntry.functionName}",
                                classEntry.kdocType,
                            )
                            receiver = classEntry.receiver

                            if (classEntry.receiver is ParameterizedTypeName) {
                                classEntry.receiver.typeArguments.filter { it != STAR }.forEach {
                                    typeVariables.add(it.toString().generics)
                                }
                            }

                            returns = UNIT
                            if (factory.extraFunctionModifier != null) {
                                addModifiers(factory.extraFunctionModifier)
                            }
                            parameters {
                                functionEntry.parameters.forEach(::add)
                            }

                            appendLine(
                                "return %L",
                                when ("coroutines") {
                                    !in factory.path ->
                                        "${functionEntry.functionName}(${
                                            parameterSpecs.toString(
                                                namedArgument = false,
                                                commaSuffix = false,
                                            )
                                        })"
                                    else ->
                                        buildString {
                                            val hasParam =
                                                (parameterSpecs.last().type as LambdaTypeName)
                                                    .parameters
                                                    .isNotEmpty()
                                            append("${functionEntry.functionName} {")
                                            if (hasParam) {
                                                append(" event ->")
                                            }
                                            append(
                                                " GlobalScope.launch(context) { " +
                                                    "${parameterSpecs.last().name}(",
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
