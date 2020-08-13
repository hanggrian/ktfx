package com.hendraanggrian.ktfx.codegen.commons

import com.hendraanggrian.kotlinpoet.collections.ParameterSpecListScope
import com.hendraanggrian.kotlinpoet.lambdaBy
import com.squareup.kotlinpoet.KModifier

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
                add("transform", CharSequence::class.lambdaBy(MatchResult::class), KModifier.NOINLINE)
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

        fun ParameterSpecListScope.predicate() =
            add("predicate", Boolean::class.lambdaBy(Char::class), KModifier.CROSSINLINE)

        fun ParameterSpecListScope.chars() = add<Char>("chars", KModifier.VARARG)
        fun ParameterSpecListScope.padChar() = "padChar"<Char> { defaultValue("\' \'") }
        fun ParameterSpecListScope.range() = add<IntRange>("range")
        inline fun <reified T> ParameterSpecListScope.delimiter() = add<T>("delimiter")
        fun ParameterSpecListScope.missingDelimiterValue() = "missingDelimiterValue"<String> { defaultValue("value") }
        fun ParameterSpecListScope.replacement() = add<String>("replacement")
        fun ParameterSpecListScope.regex() = add<Regex>("regex")
        fun ParameterSpecListScope.char() = add<Char>("char")
    }