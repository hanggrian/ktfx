package com.hendraanggrian.ktfx.codegen.commons

import com.squareup.kotlinpoet.ParameterSpec
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecHandlerScope

open class StringsFactory(val className: String) {
    companion object {
        const val BOOLEAN = "Boolean"
        const val DOUBLE = "Double"
        const val FLOAT = "Float"
        const val INT = "Int"
        const val LONG = "Long"
        const val ANY = ""
        const val STRING = "String"

        fun ParameterSpecHandlerScope.ignoreCase() = "ignoreCase"<Boolean> { defaultValue("false") }
        fun ParameterSpecHandlerScope.startIndex() = add<Int>("startIndex")
        fun ParameterSpecHandlerScope.endIndex() = add<Int>("endIndex")
        fun ParameterSpecHandlerScope.length() = add<Int>("length")
        fun ParameterSpecHandlerScope.prefix() = add<String>("prefix")
        fun ParameterSpecHandlerScope.suffix() = add<String>("suffix")
        fun ParameterSpecHandlerScope.other() = add<String>("other")
    }

    val entries = mutableListOf<StringsEntry>()

    operator fun String.invoke(
        type: String,
        notNull: Boolean = true,
        configuration: ParameterSpecHandlerScope.() -> Unit = { }
    ) {
        val parameters = mutableListOf<ParameterSpec>()
        ParameterSpecHandlerScope(parameters).configuration()
        entries += StringsEntry(type, this, notNull, parameters)
    }
}