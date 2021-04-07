package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.CROSSINLINE
import com.hendraanggrian.kotlinpoet.NOINLINE
import com.hendraanggrian.kotlinpoet.VARARG
import com.hendraanggrian.kotlinpoet.dsl.ParameterSpecHandlerScope
import com.hendraanggrian.kotlinpoet.lambdaBy

val StringsFactory.Companion.Strings: StringsFactory
    get() = object : StringsFactory("StringBinding") {
        init {
            "trim"(STRING) { predicate() }
            "trimStart"(STRING) { predicate() }
            "trimEnd"(STRING) { predicate() }
            "trim"(STRING) { chars() }
            "trimStart"(STRING) { chars() }
            "trimEnd"(STRING) { chars() }
            "trim"(STRING)
            "trimStart"(STRING)
            "trimEnd"(STRING)
            "padStart"(STRING) { length(); padChar() }
            "padEnd"(STRING) { length(); padChar() }
            "isNullOrEmpty"(BOOLEAN, notNull = false)
            "isNotBlank"(BOOLEAN)
            "isNullOrBlank"(BOOLEAN, notNull = false)
            "orEmpty"(STRING, notNull = false)
            "substring"(STRING) { range() }
            "substringBefore"(STRING) { delimiter<Char>(); missingDelimiterValue() }
            "substringBefore"(STRING) { delimiter<String>(); missingDelimiterValue() }
            "substringAfter"(STRING) { delimiter<Char>(); missingDelimiterValue() }
            "substringAfter"(STRING) { delimiter<String>(); missingDelimiterValue() }
            "substringBeforeLast"(STRING) { delimiter<Char>(); missingDelimiterValue() }
            "substringBeforeLast"(STRING) { delimiter<String>(); missingDelimiterValue() }
            "substringAfterLast"(STRING) { delimiter<Char>(); missingDelimiterValue() }
            "substringAfterLast"(STRING) { delimiter<String>(); missingDelimiterValue() }
            "replaceRange"(STRING) { startIndex(); endIndex(); replacement() }
            "replaceRange"(STRING) { range(); replacement() }
            "removeRange"(STRING) { startIndex(); endIndex() }
            "removeRange"(STRING) { range() }
            "removePrefix"(STRING) { prefix() }
            "removeSuffix"(STRING) { suffix() }
            "removeSurrounding"(STRING) { prefix(); suffix() }
            "removeSurrounding"(STRING) { delimiter<CharSequence>() }
            "replaceBefore"(STRING) { delimiter<Char>(); replacement(); missingDelimiterValue() }
            "replaceBefore"(STRING) { delimiter<String>(); replacement(); missingDelimiterValue() }
            "replaceAfter"(STRING) { delimiter<Char>(); replacement(); missingDelimiterValue() }
            "replaceAfter"(STRING) { delimiter<String>(); replacement(); missingDelimiterValue() }
            "replaceBeforeLast"(STRING) { delimiter<Char>(); replacement(); missingDelimiterValue() }
            "replaceBeforeLast"(STRING) { delimiter<String>(); replacement(); missingDelimiterValue() }
            "replaceAfterLast"(STRING) { delimiter<Char>(); replacement(); missingDelimiterValue() }
            "replaceAfterLast"(STRING) { delimiter<String>(); replacement(); missingDelimiterValue() }
            "replace"(STRING) { regex(); replacement() }
            "replace"(STRING) {
                regex()
                add("transform", CharSequence::class.lambdaBy(MatchResult::class), NOINLINE)
            }
            "replaceFirst"(STRING) { regex(); replacement() }
            "matches"(BOOLEAN) { regex() }
            "startsWith"(BOOLEAN) { char(); ignoreCase() }
            "endsWith"(BOOLEAN) { char(); ignoreCase() }
            "commonPrefixWith"(STRING) { other(); ignoreCase() }
            "commonSuffixWith"(STRING) { other(); ignoreCase() }
            "contains"(BOOLEAN) { other(); ignoreCase() }
            "contains"(BOOLEAN) { char(); ignoreCase() }
            "contains"(BOOLEAN) { regex() }
        }

        fun ParameterSpecHandlerScope.predicate() =
            "predicate"(Boolean::class.lambdaBy(Char::class), CROSSINLINE)

        fun ParameterSpecHandlerScope.chars() = "chars"<Char>(VARARG)
        fun ParameterSpecHandlerScope.padChar() = "padChar"<Char> { defaultValue("\' \'") }
        fun ParameterSpecHandlerScope.range() = "range"<IntRange>()
        inline fun <reified T> ParameterSpecHandlerScope.delimiter() = "delimiter"<T>()
        fun ParameterSpecHandlerScope.missingDelimiterValue() =
            "missingDelimiterValue"<String> { defaultValue("value") }

        fun ParameterSpecHandlerScope.replacement() = "replacement"<String>()
        fun ParameterSpecHandlerScope.regex() = "regex"<Regex>()
        fun ParameterSpecHandlerScope.char() = "char"<Char>()
    }