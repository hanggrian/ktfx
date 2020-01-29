@file:Suppress("NOTHING_TO_INLINE")

package ktfx.util

import javafx.util.StringConverter

/** Class to build [StringConverter] with Kotlin DSL. */
class StringConverterBuilder<T> @PublishedApi internal constructor() : StringConverter<T>() {
    private var _toString: (T?) -> String = { it?.toString() ?: "" }
    private var _fromString: (String) -> T? = { null }

    /** Convert the object to String. */
    fun toString(listener: (T?) -> String) {
        _toString = listener
    }

    override fun toString(any: T?): String = _toString(any)

    /** Convert String back to object. */
    fun fromString(listener: (String) -> T?) {
        _fromString = listener
    }

    override fun fromString(string: String): T? = _fromString(string)
}

/** Build string converter with Kotlin DSL. */
inline fun <T> buildStringConverter(configuration: StringConverterBuilder<T>.() -> Unit): StringConverter<T> =
    StringConverterBuilder<T>().apply(configuration)

/** Converts the object provided into its string form. */
inline operator fun <T> StringConverter<T>.invoke(obj: T): String = toString(obj)

/** Converts the string provided into an object defined by the specific converter. */
inline operator fun <T> StringConverter<T>.get(s: String): T = fromString(s)
