package ktfx.listeners.internal

import javafx.util.StringConverter
import ktfx.listeners.StringConverterBuilder

@PublishedApi
@Suppress("ClassName")
internal class _StringConverter<T> : StringConverter<T>(), StringConverterBuilder<T> {
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