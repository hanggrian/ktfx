@file:JvmMultifileClass
@file:JvmName("StringValueBindingKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.bindings

import javafx.beans.binding.BooleanBinding
import javafx.beans.binding.IntegerBinding
import javafx.beans.binding.StringBinding
import javafx.beans.value.ObservableStringValue
import java.lang.StringBuffer
import java.util.Locale
import kotlin.Any
import kotlin.Boolean
import kotlin.Char
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see String.equals
 */
inline fun ObservableStringValue.equals(other: String?, ignoreCase: Boolean = false):
    BooleanBinding {
        return asBoolean { it.equals(other, ignoreCase) }
    }

/**
 * @see String.replace
 */
inline fun ObservableStringValue.replace(
    oldChar: Char,
    newChar: Char,
    ignoreCase: Boolean = false
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replace(
            oldChar, newChar,
            ignoreCase
        )
    }
}

/**
 * @see String.replace
 */
inline fun ObservableStringValue.replace(
    oldChar: String,
    newChar: String,
    ignoreCase: Boolean = false
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replace(
            oldChar, newChar,
            ignoreCase
        )
    }
}

/**
 * @see String.replaceFirst
 */
inline fun ObservableStringValue.replaceFirst(
    oldChar: Char,
    newChar: Char,
    ignoreCase: Boolean = false
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceFirst(
            oldChar, newChar,
            ignoreCase
        )
    }
}

/**
 * @see String.replaceFirst
 */
inline fun ObservableStringValue.replaceFirst(
    oldChar: String,
    newChar: String,
    ignoreCase: Boolean = false
): StringBinding {
    return asString {
        checkNotNull(it) { "String value is null" }.replaceFirst(
            oldChar, newChar,
            ignoreCase
        )
    }
}

/**
 * @see String.toUpperCase
 */
inline fun ObservableStringValue.toUpperCase(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toUpperCase() }
}

/**
 * @see String.toLowerCase
 */
inline fun ObservableStringValue.toLowerCase(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toLowerCase() }
}

/**
 * @see String.format
 */
inline fun ObservableStringValue.format(vararg newChar: Any?): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.format(*newChar) }
}

/**
 * @see String.format
 */
inline fun ObservableStringValue.format(locale: Locale, vararg newChar: Any?): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.format(locale, *newChar) }
}

/**
 * @see String.substring
 */
inline fun ObservableStringValue.substring(startIndex: Int): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.substring(startIndex) }
}

/**
 * @see String.substring
 */
inline fun ObservableStringValue.substring(startIndex: Int, endIndex: Int): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.substring(startIndex, endIndex) }
}

/**
 * @see String.startsWith
 */
inline fun ObservableStringValue.startsWith(prefix: String, ignoreCase: Boolean = false):
    BooleanBinding {
        return asBoolean { checkNotNull(it) { "String value is null" }.startsWith(prefix, ignoreCase) }
    }

/**
 * @see String.startsWith
 */
inline fun ObservableStringValue.startsWith(
    prefix: String,
    startIndex: Int,
    ignoreCase: Boolean = false
): BooleanBinding {
    return asBoolean {
        checkNotNull(it) { "String value is null" }.startsWith(
            prefix, startIndex,
            ignoreCase
        )
    }
}

/**
 * @see String.endsWith
 */
inline fun ObservableStringValue.endsWith(suffix: String, ignoreCase: Boolean = false):
    BooleanBinding {
        return asBoolean { checkNotNull(it) { "String value is null" }.endsWith(suffix, ignoreCase) }
    }

/**
 * @see String.codePointAt
 */
inline fun ObservableStringValue.codePointAt(index: Int): IntegerBinding {
    return asInt { checkNotNull(it) { "String value is null" }.codePointAt(index) }
}

/**
 * @see String.codePointBefore
 */
inline fun ObservableStringValue.codePointBefore(index: Int): IntegerBinding {
    return asInt { checkNotNull(it) { "String value is null" }.codePointBefore(index) }
}

/**
 * @see String.codePointCount
 */
inline fun ObservableStringValue.codePointCount(startIndex: Int, endIndex: Int): IntegerBinding {
    return asInt {
        checkNotNull(it) { "String value is null" }.codePointCount(startIndex, endIndex)
    }
}

/**
 * @see String.compareTo
 */
inline fun ObservableStringValue.compareTo(other: String, ignoreCase: Boolean = false):
    IntegerBinding {
        return asInt { checkNotNull(it) { "String value is null" }.compareTo(other, ignoreCase) }
    }

/**
 * @see String.contentEquals
 */
inline fun ObservableStringValue.contentEquals(buffer: StringBuffer): BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.contentEquals(buffer) }
}

/**
 * @see String.intern
 */
inline fun ObservableStringValue.intern(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.intern() }
}

/**
 * @see String.isBlank
 */
inline fun ObservableStringValue.isBlank(): BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.isBlank() }
}

/**
 * @see String.offsetByCodePoints
 */
inline fun ObservableStringValue.offsetByCodePoints(index: Int, codePointOffset: Int):
    IntegerBinding {
        return asInt {
            checkNotNull(it) { "String value is null" }.offsetByCodePoints(
                index,
                codePointOffset
            )
        }
    }

/**
 * @see String.regionMatches
 */
inline fun ObservableStringValue.regionMatches(
    thisOffset: Int,
    other: String,
    otherOffset: Int,
    length: Int,
    ignoreCase: Boolean = false
): BooleanBinding {
    return asBoolean {
        checkNotNull(it) { "String value is null" }.regionMatches(
            thisOffset, other,
            otherOffset, length, ignoreCase
        )
    }
}

/**
 * @see String.toUpperCase
 */
inline fun ObservableStringValue.toUpperCase(locale: Locale): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toUpperCase(locale) }
}

/**
 * @see String.toLowerCase
 */
inline fun ObservableStringValue.toLowerCase(locale: Locale): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toLowerCase(locale) }
}

/**
 * @see String.capitalize
 */
inline fun ObservableStringValue.capitalize(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.capitalize() }
}

/**
 * @see String.decapitalize
 */
inline fun ObservableStringValue.decapitalize(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.decapitalize() }
}

/**
 * @see String.repeat
 */
inline fun ObservableStringValue.repeat(n: Int): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.repeat(n) }
}
