package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.buildFileSpec
import com.squareup.kotlinpoet.KModifier
import javafx.beans.value.ObservableStringValue
import java.io.File

object StringsWriter {

    fun write(factory: StringsFactory) {
        println("Generating to ${factory.path}:")
        buildFileSpec(factory.packageName, "_${factory.className}") {
            annotations {
                add<JvmMultifileClass>()
                JvmName::class { addMember("%S", "ObservableStringValueKt") }
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
                        appendln(it.statement)
                    }
                }
            }
        }.writeTo(File(factory.path))
        println("Finished!")
        println()
    }
}