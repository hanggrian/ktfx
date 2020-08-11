package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.asNullable
import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.squareup.kotlinpoet.KModifier
import java.util.Locale

val StringsFactory.Companion.StringsJVM: StringsFactory
    get() = object : StringsFactory("ObservableStringValueJVM") {
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
            "toUpperCase"(STRING) { locale() }
            "toLowerCase"(STRING) { locale() }
            "capitalize"(STRING)
            "decapitalize"(STRING)
            "repeat"(STRING) { add<Int>("n") }
        }

        fun ParameterSpecListScope.oldChar() = add<Char>("oldChar")
        fun ParameterSpecListScope.newChar() = add<Char>("newChar")
        fun ParameterSpecListScope.oldValue() = add<String>("oldChar")
        fun ParameterSpecListScope.newValue() = add<String>("newChar")
        fun ParameterSpecListScope.args() = add("newChar", Any::class.asNullable(), KModifier.VARARG)
        fun ParameterSpecListScope.locale() = add<Locale>("locale")
        fun ParameterSpecListScope.index() = add<Int>("index")
    }