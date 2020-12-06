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
public inline fun ObservableStringValue.equals(other: String?, ignoreCase: Boolean = false):
    BooleanBinding {
        return asBoolean { it.equals(other, ignoreCase) }
    }

/**
 * @see String.replace
 */
public inline fun ObservableStringValue.replace(
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
public inline fun ObservableStringValue.replace(
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
public inline fun ObservableStringValue.replaceFirst(
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
public inline fun ObservableStringValue.replaceFirst(
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
public inline fun ObservableStringValue.toUpperCase(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toUpperCase() }
}

/**
 * @see String.toLowerCase
 */
public inline fun ObservableStringValue.toLowerCase(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toLowerCase() }
}

/**
 * @see String.format
 */
public inline fun ObservableStringValue.format(vararg newChar: Any?): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.format(*newChar) }
}

/**
 * @see String.format
 */
public inline fun ObservableStringValue.format(locale: Locale, vararg newChar: Any?):
    StringBinding {
        return asString { checkNotNull(it) { "String value is null" }.format(locale, *newChar) }
    }

/**
 * @see String.substring
 */
public inline fun ObservableStringValue.substring(startIndex: Int): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.substring(startIndex) }
}

/**
 * @see String.substring
 */
public inline fun ObservableStringValue.substring(startIndex: Int, endIndex: Int): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.substring(startIndex, endIndex) }
}

/**
 * @see String.startsWith
 */
public inline fun ObservableStringValue.startsWith(prefix: String, ignoreCase: Boolean = false):
    BooleanBinding {
        return asBoolean { checkNotNull(it) { "String value is null" }.startsWith(prefix, ignoreCase) }
    }

/**
 * @see String.startsWith
 */
public inline fun ObservableStringValue.startsWith(
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
public inline fun ObservableStringValue.endsWith(suffix: String, ignoreCase: Boolean = false):
    BooleanBinding {
        return asBoolean { checkNotNull(it) { "String value is null" }.endsWith(suffix, ignoreCase) }
    }

/**
 * @see String.codePointAt
 */
public inline fun ObservableStringValue.codePointAt(index: Int): IntegerBinding {
    return asInt { checkNotNull(it) { "String value is null" }.codePointAt(index) }
}

/**
 * @see String.codePointBefore
 */
public inline fun ObservableStringValue.codePointBefore(index: Int): IntegerBinding {
    return asInt { checkNotNull(it) { "String value is null" }.codePointBefore(index) }
}

/**
 * @see String.codePointCount
 */
public inline fun ObservableStringValue.codePointCount(startIndex: Int, endIndex: Int):
    IntegerBinding {
        return asInt {
            checkNotNull(it) { "String value is null" }.codePointCount(startIndex, endIndex)
        }
    }

/**
 * @see String.compareTo
 */
public inline fun ObservableStringValue.compareTo(other: String, ignoreCase: Boolean = false):
    IntegerBinding {
        return asInt { checkNotNull(it) { "String value is null" }.compareTo(other, ignoreCase) }
    }

/**
 * @see String.contentEquals
 */
public inline fun ObservableStringValue.contentEquals(buffer: StringBuffer): BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.contentEquals(buffer) }
}

/**
 * @see String.intern
 */
public inline fun ObservableStringValue.intern(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.intern() }
}

/**
 * @see String.isBlank
 */
public inline fun ObservableStringValue.isBlank(): BooleanBinding {
    return asBoolean { checkNotNull(it) { "String value is null" }.isBlank() }
}

/**
 * @see String.offsetByCodePoints
 */
public inline fun ObservableStringValue.offsetByCodePoints(index: Int, codePointOffset: Int):
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
public inline fun ObservableStringValue.regionMatches(
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
public inline fun ObservableStringValue.toUpperCase(locale: Locale): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toUpperCase(locale) }
}

/**
 * @see String.toLowerCase
 */
public inline fun ObservableStringValue.toLowerCase(locale: Locale): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.toLowerCase(locale) }
}

/**
 * @see String.capitalize
 */
public inline fun ObservableStringValue.capitalize(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.capitalize() }
}

/**
 * @see String.decapitalize
 */
public inline fun ObservableStringValue.decapitalize(): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.decapitalize() }
}

/**
 * @see String.repeat
 */
public inline fun ObservableStringValue.repeat(n: Int): StringBinding {
    return asString { checkNotNull(it) { "String value is null" }.repeat(n) }
}
