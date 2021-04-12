@file:JvmMultifileClass
@file:JvmName("StringValueBindingKt")
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
public inline fun ObservableStringValue.trim(crossinline predicate: (Char) -> Boolean):
    StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trim(predicate) }
}

/**
 * @see String.trimStart
 */
public inline fun ObservableStringValue.trimStart(crossinline predicate: (Char) -> Boolean):
    StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trimStart(predicate) }
}

/**
 * @see String.trimEnd
 */
public inline fun ObservableStringValue.trimEnd(crossinline predicate: (Char) -> Boolean):
    StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trimEnd(predicate) }
}

/**
 * @see String.trim
 */
public inline fun ObservableStringValue.trim(vararg chars: Char): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trim(*chars) }
}

/**
 * @see String.trimStart
 */
public inline fun ObservableStringValue.trimStart(vararg chars: Char): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trimStart(*chars) }
}

/**
 * @see String.trimEnd
 */
public inline fun ObservableStringValue.trimEnd(vararg chars: Char): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trimEnd(*chars) }
}

/**
 * @see String.trim
 */
public inline fun ObservableStringValue.trim(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trim() }
}

/**
 * @see String.trimStart
 */
public inline fun ObservableStringValue.trimStart(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trimStart() }
}

/**
 * @see String.trimEnd
 */
public inline fun ObservableStringValue.trimEnd(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.trimEnd() }
}

/**
 * @see String.padStart
 */
public inline fun ObservableStringValue.padStart(length: Int, padChar: Char = ' '): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.padStart(length, padChar) }
}

/**
 * @see String.padEnd
 */
public inline fun ObservableStringValue.padEnd(length: Int, padChar: Char = ' '): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.padEnd(length, padChar) }
}

/**
 * @see String.isNullOrEmpty
 */
public inline fun ObservableStringValue.isNullOrEmpty(): BooleanBinding {
    return asBoolean { it.isNullOrEmpty() }
}

/**
 * @see String.isNotBlank
 */
public inline fun ObservableStringValue.isNotBlank(): BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.isNotBlank() }
}

/**
 * @see String.isNullOrBlank
 */
public inline fun ObservableStringValue.isNullOrBlank(): BooleanBinding {
    return asBoolean { it.isNullOrBlank() }
}

/**
 * @see String.orEmpty
 */
public inline fun ObservableStringValue.orEmpty(): StringBinding {
    return asString { it.orEmpty() }
}

/**
 * @see String.substring
 */
public inline fun ObservableStringValue.substring(range: IntRange): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.substring(range) }
}

/**
 * @see String.substringBefore
 */
public inline fun ObservableStringValue.substringBefore(
    delimiter: Char,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringBefore(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.substringBefore
 */
public inline fun ObservableStringValue.substringBefore(
    delimiter: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringBefore(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.substringAfter
 */
public inline fun ObservableStringValue.substringAfter(
    delimiter: Char,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringAfter(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.substringAfter
 */
public inline fun ObservableStringValue.substringAfter(
    delimiter: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringAfter(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.substringBeforeLast
 */
public inline fun ObservableStringValue.substringBeforeLast(
    delimiter: Char,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringBeforeLast(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.substringBeforeLast
 */
public inline fun ObservableStringValue.substringBeforeLast(
    delimiter: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringBeforeLast(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.substringAfterLast
 */
public inline fun ObservableStringValue.substringAfterLast(
    delimiter: Char,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringAfterLast(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.substringAfterLast
 */
public inline fun ObservableStringValue.substringAfterLast(
    delimiter: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.substringAfterLast(
            delimiter,
            missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceRange
 */
public inline fun ObservableStringValue.replaceRange(
    startIndex: Int,
    endIndex: Int,
    replacement: String
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceRange(
            startIndex, endIndex,
            replacement
        )
    }
}

/**
 * @see String.replaceRange
 */
public inline fun ObservableStringValue.replaceRange(range: IntRange, replacement: String):
    StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.replaceRange(range, replacement) }
}

/**
 * @see String.removeRange
 */
public inline fun ObservableStringValue.removeRange(startIndex: Int, endIndex: Int): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.removeRange(startIndex, endIndex)
    }
}

/**
 * @see String.removeRange
 */
public inline fun ObservableStringValue.removeRange(range: IntRange): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.removeRange(range) }
}

/**
 * @see String.removePrefix
 */
public inline fun ObservableStringValue.removePrefix(prefix: String): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.removePrefix(prefix) }
}

/**
 * @see String.removeSuffix
 */
public inline fun ObservableStringValue.removeSuffix(suffix: String): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.removeSuffix(suffix) }
}

/**
 * @see String.removeSurrounding
 */
public inline fun ObservableStringValue.removeSurrounding(prefix: String, suffix: String):
    StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.removeSurrounding(prefix, suffix)
    }
}

/**
 * @see String.removeSurrounding
 */
public inline fun ObservableStringValue.removeSurrounding(delimiter: CharSequence): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.removeSurrounding(delimiter) }
}

/**
 * @see String.replaceBefore
 */
public inline fun ObservableStringValue.replaceBefore(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceBefore(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceBefore
 */
public inline fun ObservableStringValue.replaceBefore(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceBefore(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceAfter
 */
public inline fun ObservableStringValue.replaceAfter(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceAfter(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceAfter
 */
public inline fun ObservableStringValue.replaceAfter(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceAfter(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceBeforeLast
 */
public inline fun ObservableStringValue.replaceBeforeLast(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceBeforeLast(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceBeforeLast
 */
public inline fun ObservableStringValue.replaceBeforeLast(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceBeforeLast(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceAfterLast
 */
public inline fun ObservableStringValue.replaceAfterLast(
    delimiter: Char,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceAfterLast(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replaceAfterLast
 */
public inline fun ObservableStringValue.replaceAfterLast(
    delimiter: String,
    replacement: String,
    missingDelimiterValue: String = value
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceAfterLast(
            delimiter,
            replacement, missingDelimiterValue
        )
    }
}

/**
 * @see String.replace
 */
public inline fun ObservableStringValue.replace(regex: Regex, replacement: String): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.replace(regex, replacement) }
}

/**
 * @see String.replace
 */
public inline fun ObservableStringValue.replace(
    regex: Regex,
    noinline transform: (MatchResult) ->    
    CharSequence
): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.replace(regex, transform) }
}

/**
 * @see String.replaceFirst
 */
public inline fun ObservableStringValue.replaceFirst(regex: Regex, replacement: String):
    StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.replaceFirst(regex, replacement) }
}

/**
 * @see String.matches
 */
public inline fun ObservableStringValue.matches(regex: Regex): BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.matches(regex) }
}

/**
 * @see String.startsWith
 */
public inline fun ObservableStringValue.startsWith(char: Char, ignoreCase: Boolean = false):
    BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.startsWith(char, ignoreCase) }
}

/**
 * @see String.endsWith
 */
public inline fun ObservableStringValue.endsWith(char: Char, ignoreCase: Boolean = false):
    BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.endsWith(char, ignoreCase) }
}

/**
 * @see String.commonPrefixWith
 */
public inline fun ObservableStringValue.commonPrefixWith(
    other: String,
    ignoreCase: Boolean =    
        false
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.commonPrefixWith(
            other,
            ignoreCase
        )
    }
}

/**
 * @see String.commonSuffixWith
 */
public inline fun ObservableStringValue.commonSuffixWith(
    other: String,
    ignoreCase: Boolean =    
        false
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.commonSuffixWith(
            other,
            ignoreCase
        )
    }
}

/**
 * @see String.contains
 */
public inline fun ObservableStringValue.contains(other: String, ignoreCase: Boolean = false):
    BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.contains(other, ignoreCase) }
}

/**
 * @see String.contains
 */
public inline fun ObservableStringValue.contains(char: Char, ignoreCase: Boolean = false):
    BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.contains(char, ignoreCase) }
}

/**
 * @see String.contains
 */
public inline fun ObservableStringValue.contains(regex: Regex): BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.contains(regex) }
}
