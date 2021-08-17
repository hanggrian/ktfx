package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.FileSpecBuilder
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.TypeName

data class ListenersClassEntry(
    val receiver: TypeName,
    val extraFunctionModifier: KModifier?,
    val functions: MutableList<ListenersFunctionEntry>,
    val extraFileConfiguration: FileSpecBuilder.() -> Unit
) {

    val generatedName: String
        get() = when (receiver) {
            is ParameterizedTypeName -> receiver.rawType
            else -> receiver
        }.toString().substringAfterLast('.')

    val kdocType: TypeName
        get() = when (receiver) {
            is ParameterizedTypeName -> receiver.rawType
            else -> receiver
        }
}

data class ListenersFunctionEntry(
    val functionName: String,
    val parameters: List<ParameterSpec>
) {

    val simpleFunctionName: String
        get() = when {
            functionName.startsWith("set") -> {
                val s = functionName.substringAfter("set")
                s.first().lowercaseChar() + s.drop(1)
            }
            else -> functionName
        }
}