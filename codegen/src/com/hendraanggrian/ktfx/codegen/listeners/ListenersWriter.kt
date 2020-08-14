package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.buildFileSpec
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.STAR
import java.io.File

object ListenersWriter {

    fun write(factory: ListenersFactory) {
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
                            appendln(
                                when ("coroutines") {
                                    in factory.path -> functionEntry.coroutineStatement
                                    else -> functionEntry.listenerStatement
                                }
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