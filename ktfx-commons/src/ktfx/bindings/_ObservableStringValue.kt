@file:JvmMultifileClass
@file:JvmName("ObservableStringBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableStringValue
import kotlin.Boolean
import kotlin.Char
import kotlin.CharSequence
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.ranges.IntRange
import kotlin.text.MatchResult
import kotlin.text.Regex

/**
 * @see String.trim
 */
inline fun ObservableStringValue.trim(crossinline predicate: (Char) -> Boolean): StringBinding =
    toStringBinding { checkNotNull(it) { "String value is null" }.trim(predicate) }

/**
 * @see String.trimStart
 */
inline fun ObservableStringValue.trimStart(crossinline predicate: (Char) -> Boolean): StringBinding =
    toStringBinding { checkNotNull(it) { "String value is null" }.trimStart(predicate) }

/**
 * @see String.trimEnd
 */
inline fun ObservableStringValue.trimEnd(crossinline predicate: (Char) -> Boolean): StringBinding =
    toStringBinding { checkNotNull(it) { "String value is null" }.trimEnd(predicate) }

/**
 * @see String.trim
 */
inline fun ObservableStringValue.trim(vararg chars: Char): StringBinding = toStringBinding {
    checkNotNull(it) { "String value is null" }.trim(*chars)
}

/**
 * @see String.trimStart
 */
inline fun ObservableStringValue.trimStart(vararg chars: Char): StringBinding = toStringBinding {
    checkNotNull(it) { "String value is null" }.trimStart(*chars)
}

/**
 * @see String.trimEnd
 */
inline fun ObservableStringValue.trimEnd(vararg chars: Char): StringBinding = toStringBinding {
    checkNotNull(it) { "String value is null" }.trimEnd(*chars)
}

/**
 * @see String.trim
 */
inline fun ObservableStringValue.trim(): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.trim()
}

/**
 * @see String.trimStart
 */
inline fun ObservableStringValue.trimStart(): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.trimStart()
}

/**
 * @see String.trimEnd
 */
inline fun ObservableStringValue.trimEnd(): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.trimEnd()
}

/**
 * @see String.padStart
 */
inline fun ObservableStringValue.padStart(length: Int, padChar: Char = ' '): StringBinding =
    toStringBinding { checkNotNull(it) { "String value is null" }.padStart(length, padChar) }

/**
 * @see String.padEnd
 */
inline fun ObservableStringValue.padEnd(length: Int, padChar: Char = ' '): StringBinding =
    toStringBinding { checkNotNull(it) { "String value is null" }.padEnd(length, padChar) }

/**
 * @see String.isNullOrEmpty
 */
inline fun ObservableStringValue.isNullOrEmpty(): BooleanBinding = toBooleanBinding {
    it.isNullOrEmpty()
}

/**
 * @see String.isNotBlank
 */
inline fun ObservableStringValue.isNotBlank(): BooleanBinding = toBooleanBinding { checkNotNull(it) { "String value is null" }.isNotBlank() }

/**
 * @see String.isNullOrBlank
 */
inline fun ObservableStringValue.isNullOrBlank(): BooleanBinding = toBooleanBinding {
    it.isNullOrBlank()
}

/**
 * @see String.orEmpty
 */
inline fun ObservableStringValue.orEmpty(): StringBinding = toStringBinding { it.orEmpty() }

/**
 * @see String.substring
 */
inline fun ObservableStringValue.substring(range: IntRange): StringBinding = toStringBinding {
    checkNotNull(it) { "String value is null" }.substring(range)
}

/**
 * @see String.substringBefore
 */
inline fun ObservableStringValue.substringBefore(
    delimiter: Char,
    missingDelimiterValue: String =    
        value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringBefore(delimiter, missingDelimiterValue)
}

/**
 * @see String.substringBefore
 */
inline fun ObservableStringValue.substringBefore(
    delimiter: String,
    missingDelimiterValue: String =    
        value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringBefore(delimiter, missingDelimiterValue)
}

/**
 * @see String.substringAfter
 */
inline fun ObservableStringValue.substringAfter(
    delimiter: Char,
    missingDelimiterValue: String =    
        value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringAfter(delimiter, missingDelimiterValue)
}

/**
 * @see String.substringAfter
 */
inline fun ObservableStringValue.substringAfter(
    delimiter: String,
    missingDelimiterValue: String =    
        value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringAfter(delimiter, missingDelimiterValue)
}

/**
 * @see String.substringBeforeLast
 */
inline fun ObservableStringValue.substringBeforeLast(
    delimiter: Char,
    missingDelimiterValue: String =    
        value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringBeforeLast(delimiter, missingDelimiterValue)
}

/**
 * @see String.substringBeforeLast
 */
inline fun ObservableStringValue.substringBeforeLast(
    delimiter: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringBeforeLast(delimiter, missingDelimiterValue)
}

/**
 * @see String.substringAfterLast
 */
inline fun ObservableStringValue.substringAfterLast(
    delimiter: Char,
    missingDelimiterValue: String =    
        value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringAfterLast(delimiter, missingDelimiterValue)
}

/**
 * @see String.substringAfterLast
 */
inline fun ObservableStringValue.substringAfterLast(
    delimiter: String,
    missingDelimiterValue: String =    
        value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.substringAfterLast(delimiter, missingDelimiterValue)
}

/**
 * @see String.replaceRange
 */
inline fun ObservableStringValue.replaceRange(
    startIndex: Int,
    endIndex: Int,
    replacement: String
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceRange(startIndex, endIndex, replacement)
}

/**
 * @see String.replaceRange
 */
inline fun ObservableStringValue.replaceRange(range: IntRange, replacement: String): StringBinding =
    toStringBinding {
        checkNotNull(it) { "String value is null" }.replaceRange(
            range,
            replacement
        )
    }

/**
 * @see String.removeRange
 */
inline fun ObservableStringValue.removeRange(startIndex: Int, endIndex: Int): StringBinding =
    toStringBinding {
        checkNotNull(it) { "String value is null" }.removeRange(
            startIndex,
            endIndex
        )
    }

/**
 * @see String.removeRange
 */
inline fun ObservableStringValue.removeRange(range: IntRange): StringBinding = toStringBinding {
    checkNotNull(it) { "String value is null" }.removeRange(range)
}

/**
 * @see String.removePrefix
 */
inline fun ObservableStringValue.removePrefix(prefix: String): StringBinding = toStringBinding {
    checkNotNull(it) { "String value is null" }.removePrefix(prefix)
}

/**
 * @see String.removeSuffix
 */
inline fun ObservableStringValue.removeSuffix(suffix: String): StringBinding = toStringBinding {
    checkNotNull(it) { "String value is null" }.removeSuffix(suffix)
}

/**
 * @see String.removeSurrounding
 */
inline fun ObservableStringValue.removeSurrounding(prefix: String, suffix: String): StringBinding =
    toStringBinding {
        checkNotNull(it) { "String value is null" }.removeSurrounding(
            prefix,
            suffix
        )
    }

/**
 * @see String.removeSurrounding
 */
inline fun ObservableStringValue.removeSurrounding(delimiter: CharSequence): StringBinding =
    toStringBinding { checkNotNull(it) { "String value is null" }.removeSurrounding(delimiter) }

/**
 * @see String.replaceBefore
 */
inline fun ObservableStringValue.replaceBefore(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceBefore(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replaceBefore
 */
inline fun ObservableStringValue.replaceBefore(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceBefore(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replaceAfter
 */
inline fun ObservableStringValue.replaceAfter(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceAfter(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replaceAfter
 */
inline fun ObservableStringValue.replaceAfter(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceAfter(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replaceBeforeLast
 */
inline fun ObservableStringValue.replaceBeforeLast(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceBeforeLast(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replaceBeforeLast
 */
inline fun ObservableStringValue.replaceBeforeLast(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceBeforeLast(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replaceAfterLast
 */
inline fun ObservableStringValue.replaceAfterLast(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceAfterLast(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replaceAfterLast
 */
inline fun ObservableStringValue.replaceAfterLast(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replaceAfterLast(delimiter, replacement, missingDelimiterValue)
}

/**
 * @see String.replace
 */
inline fun ObservableStringValue.replace(regex: Regex, replacement: String): StringBinding =
    toStringBinding { checkNotNull(it) { "String value is null" }.replace(regex, replacement) }

/**
 * @see String.replace
 */
inline fun ObservableStringValue.replace(
    regex: Regex,
    noinline transform: (MatchResult) ->    
    CharSequence
): StringBinding = toStringBinding {
    checkNotNull(it) {
        "String value is null"
    }.replace(regex, transform)
}

/**
 * @see String.replaceFirst
 */
inline fun ObservableStringValue.replaceFirst(regex: Regex, replacement: String): StringBinding =
    toStringBinding {
        checkNotNull(it) { "String value is null" }.replaceFirst(
            regex,
            replacement
        )
    }

/**
 * @see String.matches
 */
inline fun ObservableStringValue.matches(regex: Regex): BooleanBinding = toBooleanBinding {
    checkNotNull(it) { "String value is null" }.matches(regex)
}

/**
 * @see String.startsWith
 */
inline fun ObservableStringValue.startsWith(char: Char, ignoreCase: Boolean = false): BooleanBinding =
    toBooleanBinding {
        checkNotNull(it) { "String value is null" }.startsWith(
            char,
            ignoreCase
        )
    }

/**
 * @see String.endsWith
 */
inline fun ObservableStringValue.endsWith(char: Char, ignoreCase: Boolean = false): BooleanBinding =
    toBooleanBinding { checkNotNull(it) { "String value is null" }.endsWith(char, ignoreCase) }

/**
 * @see String.commonPrefixWith
 */
inline fun ObservableStringValue.commonPrefixWith(other: String, ignoreCase: Boolean = false):
    StringBinding = toStringBinding {
        checkNotNull(it) {
            "String value is null"
        }.commonPrefixWith(other, ignoreCase)
    }

/**
 * @see String.commonSuffixWith
 */
inline fun ObservableStringValue.commonSuffixWith(other: String, ignoreCase: Boolean = false):
    StringBinding = toStringBinding {
        checkNotNull(it) {
            "String value is null"
        }.commonSuffixWith(other, ignoreCase)
    }

/**
 * @see String.contains
 */
inline fun ObservableStringValue.contains(other: String, ignoreCase: Boolean = false):
    BooleanBinding = toBooleanBinding {
        checkNotNull(it) {
            "String value is null"
        }.contains(other, ignoreCase)
    }

/**
 * @see String.contains
 */
inline fun ObservableStringValue.contains(char: Char, ignoreCase: Boolean = false): BooleanBinding =
    toBooleanBinding { checkNotNull(it) { "String value is null" }.contains(char, ignoreCase) }

/**
 * @see String.contains
 */
inline fun ObservableStringValue.contains(regex: Regex): BooleanBinding = toBooleanBinding {
    checkNotNull(it) { "String value is null" }.contains(regex)
}
