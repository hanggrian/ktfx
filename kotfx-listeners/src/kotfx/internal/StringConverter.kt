@file:Suppress("NOTHING_TO_INLINE")

package kotfx.internal

import javafx.util.StringConverter
import kotfx.util.StringConverterBuilder

@PublishedApi
internal inline fun <T> (StringConverterBuilder<T>.() -> Unit).asConverter(): StringConverter<T> = _StringConverterBuilder<T>().apply(this)

@PublishedApi
internal class _StringConverterBuilder<T> : StringConverter<T>(), StringConverterBuilder<T> {

    private var toString: ((T?) -> String)? = null
    private var fromString: ((String) -> T?)? = null

    override fun toString(any: T?): String {
        val handler = toString ?: return any?.toString() ?: ""
        return handler(any)
    }

    override fun fromString(string: String): T? {
        val handler = fromString ?: return null
        return handler(string)
    }

    override fun toString(listener: (T?) -> String) {
        toString = listener
    }

    override fun fromString(listener: (String) -> T?) {
        fromString = listener
    }
}