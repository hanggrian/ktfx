package com.hendraanggrian.ktfx.codegen.listeners

import com.hendraanggrian.kotlinpoet.FileSpecBuilder
import com.hendraanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
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

    val simpleFunctionName = functionName.replace("setOn", "on")

    val listenerStatement: String
        get() = "return $functionName(${parameters.toString(
            namedArgument = false,
            commaSuffix = false
        )})"

    val coroutineStatement: String
        get() {
            val hasParam = (parameters.last().type as LambdaTypeName).parameters.isNotEmpty()
            return buildString {
                append("return $functionName {")
                if (hasParam) {
                    append(" event ->")
                }
                append(" GlobalScope.launch(context) { ${parameters.last().name}(")
                if(hasParam) {
                    append("event")
                }
                append(") } }")
            }
        }
}