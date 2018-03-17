@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kfx.listeners

import javafx.util.StringConverter

/** Interface to build [StringConverter] with Kotlin DSL. */
interface StringConverterBuilder<T> {

    /** Convert the object to String. */
    fun toString(listener: (T?) -> String)

    /** Convert String back to object. */
    fun fromString(listener: (String) -> T?)
}

@PublishedApi
internal class _StringConverterBuilder<T> : StringConverter<T>(), StringConverterBuilder<T> {
    private var _toString: (T?) -> String = { it?.toString() ?: "" }
    private var _fromString: (String) -> T? = { null }

    override fun toString(listener: (T?) -> String) {
        _toString = listener
    }

    override fun toString(any: T?): String = _toString(any)

    override fun fromString(listener: (String) -> T?) {
        _fromString = listener
    }

    override fun fromString(string: String): T? = _fromString(string)
}

@PublishedApi internal inline fun <T> (StringConverterBuilder<T>.() -> Unit).build(): StringConverter<T> =
    _StringConverterBuilder<T>().apply(this)