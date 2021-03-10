package io.github.hendraanggrian.ktfx.codegen.listeners

import io.github.hendraanggrian.kotlinpoet.buildFileSpec
import io.github.hendraanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.STAR
import java.io.File

object ListenersWriter {

    fun write(factory: BaseListenersFactory) {
        println("Generating to ${factory.path}:")
        factory.entries.forEach { classEntry ->
            buildFileSpec(factory.packageName, "_${classEntry.generatedName}") {
                indentSize = 4
                annotations {
                    add<JvmMultifileClass>()
                    JvmName::class { addMember("%S", factory.className) }
                }
                classEntry.functions.forEach { functionEntry ->
                    functions {
                        functionEntry.simpleFunctionName {
                            kdoc.append("@see %T.${functionEntry.functionName}", classEntry.kdocType)
                            receiver = classEntry.receiver

                            if (classEntry.receiver is ParameterizedTypeName) {
                                classEntry.receiver.typeArguments.filter { it != STAR }.forEach {
                                    typeVariables += it.toString()
                                }
                            }

                            returns<Unit>()
                            if (factory.extraFunctionModifier != null) {
                                addModifiers(factory.extraFunctionModifier)
                            }
                            parameters {
                                functionEntry.parameters.forEach(::plusAssign)
                            }

                            appendLine {
                                append("return ")
                                when ("coroutines") {
                                    !in factory.path -> append(
                                        "${functionEntry.functionName}(${parameters.toString(
                                            namedArgument = false,
                                            commaSuffix = false
                                        )})"
                                    )
                                    else -> {
                                        val hasParam = (parameters.last().type as LambdaTypeName)
                                            .parameters.isNotEmpty()
                                        append("${functionEntry.functionName} {")
                                        if (hasParam) {
                                            append(" event ->")
                                        }
                                        append(" GlobalScope.launch(context) { ${parameters.last().name}(")
                                        if (hasParam) {
                                            append("event")
                                        }
                                        append(") } }")
                                    }
                                }
                            }
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