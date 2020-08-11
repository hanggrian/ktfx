package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.parameterizedBy
import com.hendraanggrian.ktfx.codegen.toString
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.asTypeName
import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.DoubleBinding
import javafx.beans.binding.FloatBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.LongBinding
import javafx.beans.binding.ObjectBinding
import javafx.beans.binding.StringBinding

data class StringsEntry(
    val type: String,
    val functionName: String,
    val notNull: Boolean,
    val parameters: List<ParameterSpec>
) {

    val returnType: TypeName
        get() = when (type) {
            StringsFactory.BOOLEAN -> BooleanBinding::class.asTypeName()
            StringsFactory.DOUBLE -> DoubleBinding::class.asTypeName()
            StringsFactory.FLOAT -> FloatBinding::class.asTypeName()
            StringsFactory.INT -> IntegerBinding::class.asTypeName()
            StringsFactory.LONG -> LongBinding::class.asTypeName()
            StringsFactory.ANY -> ObjectBinding::class.parameterizedBy()
            StringsFactory.STRING -> StringBinding::class.asTypeName()
            else -> error("Unrecognizable type")
        }

    val statement: String
        get() = buildString {
            append("return to${type}Binding { ")
            append(
                when {
                    notNull -> "checkNotNull(it) { \"String value is null\" }"
                    else -> "it"
                }
            )
            append(
                ".${functionName}(${parameters.toString(
                    namedArgument = false,
                    commaSuffix = false
                )}) }"
            )
        }
}