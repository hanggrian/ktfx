package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.squareup.kotlinpoet.ParameterSpec

open class StringsFactory(val className: String) {
    companion object {
        const val BOOLEAN = "Boolean"
        const val DOUBLE = "Double"
        const val FLOAT = "Float"
        const val INT = "Int"
        const val LONG = "Long"
        const val ANY = ""
        const val STRING = "String"

        fun ParameterSpecListScope.ignoreCase() = "ignoreCase"<Boolean> { defaultValue("false") }
        fun ParameterSpecListScope.startIndex() = add<Int>("startIndex")
        fun ParameterSpecListScope.endIndex() = add<Int>("endIndex")
        fun ParameterSpecListScope.length() = add<Int>("length")
        fun ParameterSpecListScope.prefix() = add<String>("prefix")
        fun ParameterSpecListScope.suffix() = add<String>("suffix")
        fun ParameterSpecListScope.other() = add<String>("other")
    }

    val entries = mutableListOf<StringsEntry>()

    operator fun String.invoke(
        type: String,
        notNull: Boolean = true,
        configuration: ParameterSpecListScope.() -> Unit = { }
    ) {
        val parameters = mutableListOf<ParameterSpec>()
        ParameterSpecListScope(parameters).configuration()
        entries += StringsEntry(type, this, notNull, parameters)
    }
}