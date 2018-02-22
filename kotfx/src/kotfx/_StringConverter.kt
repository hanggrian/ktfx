package kotfx

import javafx.util.StringConverter

class _StringConverter<T> : StringConverter<T>() {

    private var _toString: ((T?) -> String)? = null
    private var _fromString: ((String) -> T?)? = null

    override fun toString(any: T?): String {
        val handler = _toString ?: return any?.toString() ?: ""
        return handler(any)
    }

    override fun fromString(string: String): T? {
        val handler = _fromString ?: return null
        return handler(string)
    }

    fun toString(listener: (T?) -> String) {
        _toString = listener
    }

    fun fromString(listener: (String) -> T?) {
        _fromString = listener
    }
}