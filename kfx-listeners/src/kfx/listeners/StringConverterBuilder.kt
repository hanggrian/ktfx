@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kfx.listeners

import javafx.util.StringConverter

interface StringConverterBuilder<T> {

    fun toString(listener: (T?) -> String)

    fun fromString(listener: (String) -> T?)
}

@PublishedApi
internal class _StringConverterBuilder<T> : StringConverter<T>(), StringConverterBuilder<T> {
    private var toString: ((T?) -> String)? = null
    private var fromString: ((String) -> T?)? = null

    override fun toString(listener: (T?) -> String) {
        toString = listener
    }

    override fun toString(any: T?): String {
        val handler = toString ?: return any?.toString() ?: ""
        return handler(any)
    }

    override fun fromString(listener: (String) -> T?) {
        fromString = listener
    }

    override fun fromString(string: String): T? {
        val handler = fromString ?: return null
        return handler(string)
    }
}

@PublishedApi internal inline fun <T> (StringConverterBuilder<T>.() -> Unit).build(): StringConverter<T> =
    _StringConverterBuilder<T>().apply(this)