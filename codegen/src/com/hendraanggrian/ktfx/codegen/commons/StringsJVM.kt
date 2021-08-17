package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.VARARG
import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecHandlerScope
import java.util.Locale

val StringsFactory.Companion.StringsJVM: StringsFactory
    get() = object : StringsFactory("StringJVMBinding") {
        init {
            "equals"(BOOLEAN, notNull = false) { add("other", String::class.asNullable()); ignoreCase() }
            "replace"(STRING) { oldChar(); newChar(); ignoreCase() }
            "replace"(STRING) { oldValue(); newValue(); ignoreCase() }
            "replaceFirst"(STRING) { oldChar(); newChar(); ignoreCase() }
            "replaceFirst"(STRING) { oldValue(); newValue(); ignoreCase() }
            "toUpperCase"(STRING)
            "toLowerCase"(STRING)
            "format"(STRING) { args() }
            "format"(STRING) { locale(); args() }
            "substring"(STRING) { startIndex(); }
            "substring"(STRING) { startIndex(); endIndex() }
            "startsWith"(BOOLEAN) { prefix(); ignoreCase() }
            "startsWith"(BOOLEAN) { prefix(); startIndex(); ignoreCase() }
            "endsWith"(BOOLEAN) { suffix(); ignoreCase() }
            "codePointAt"(INT) { index() }
            "codePointBefore"(INT) { index() }
            "codePointCount"(INT) { startIndex(); endIndex() }
            "compareTo"(INT) { other(); ignoreCase() }
            "contentEquals"(BOOLEAN) { add<StringBuffer>("buffer") }
            "intern"(STRING)
            "isBlank"(BOOLEAN)
            "offsetByCodePoints"(INT) { index(); add<Int>("codePointOffset") }
            "regionMatches"(BOOLEAN) {
                add<Int>("thisOffset")
                other()
                add<Int>("otherOffset")
                length()
                ignoreCase()
            }
            "uppercase"(STRING) { locale() }
            "lowercase"(STRING) { locale() }
            "repeat"(STRING) { add<Int>("n") }
        }

        fun ParameterSpecHandlerScope.oldChar() = add<Char>("oldChar")
        fun ParameterSpecHandlerScope.newChar() = add<Char>("newChar")
        fun ParameterSpecHandlerScope.oldValue() = add<String>("oldChar")
        fun ParameterSpecHandlerScope.newValue() = add<String>("newChar")
        fun ParameterSpecHandlerScope.args() = add("newChar", Any::class.asNullable(), VARARG)
        fun ParameterSpecHandlerScope.locale() = add<Locale>("locale")
        fun ParameterSpecHandlerScope.index() = add<Int>("index")
    }