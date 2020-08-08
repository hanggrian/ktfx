@file:Suppress("NOTHING_TO_INLINE")

package ktfx.text

import javafx.util.StringConverter

/**
 * Builds new string converter.
 * @param builderAction configure [StringConverterBuilder.toString] and [StringConverterBuilder.fromString]
 * @return configured string converter.
 * @see kotlin.text.buildString
 */
inline fun <T> buildStringConverter(builderAction: StringConverterBuilder<T>.() -> Unit): StringConverter<T> =
    StringConverterBuilder<T>().apply(builderAction).build()

/** Receiver for `buildStringConverter` block. */
class StringConverterBuilder<T> {
    private var _toString: (T?) -> String = { it?.toString() ?: "" }
    private var _fromString: (String) -> T? = { null }

    /** Convert the object to String. */
    fun toString(listener: (T?) -> String) {
        _toString = listener
    }

    /** Convert String back to object. */
    fun fromString(listener: (String) -> T?) {
        _fromString = listener
    }

    /** Create to native builder. */
    fun build(): StringConverter<T> = object : StringConverter<T>() {
        override fun toString(any: T?): String = _toString(any)
        override fun fromString(string: String): T? = _fromString(string)
    }
}

/** Converts the object provided into its string form. */
inline operator fun <T> StringConverter<T>.invoke(obj: T): String = toString(obj)

/** Converts the string provided into an object defined by the specific converter. */
inline operator fun <T> StringConverter<T>.get(s: String): T = fromString(s)
