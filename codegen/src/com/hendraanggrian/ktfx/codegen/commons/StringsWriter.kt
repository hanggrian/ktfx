package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.buildFileSpec
import com.hendraanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.KModifier
import javafx.beans.value.ObservableStringValue
import java.io.File

object StringsWriter {

    fun write(factory: StringsFactory) {
        println("Generating to ktfx-commons/src")
        buildFileSpec("ktfx.bindings", "_${factory.className}") {
            indentSize = 4
            annotations {
                add<JvmMultifileClass>()
                JvmName::class { addMember("%S", "StringBindingKt") }
                Suppress::class { addMember("%S", "NOTHING_TO_INLINE") }
            }
            functions {
                factory.entries.forEach {
                    it.functionName {
                        kdoc += "@see String.${it.functionName}"
                        addModifiers(KModifier.INLINE)
                        receiver<ObservableStringValue>()
                        returns = it.returnType
                        parameters { it.parameters.forEach(::plusAssign) }
                        appendLine {
                            append("return to${it.type}Binding { ")
                            append(
                                when {
                                    it.notNull -> "checkNotNull(it) { \"String value is null\" }"
                                    else -> "it"
                                }
                            )
                            append(
                                ".${it.functionName}(${parameters.toString(
                                    namedArgument = false,
                                    commaSuffix = false
                                )}) }"
                            )
                        }
                    }
                }
            }
        }.writeTo(File("ktfx-commons/src"))
        println("Finished!")
        println()
    }
}