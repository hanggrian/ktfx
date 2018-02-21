package kotfx.coroutines

import javafx.util.StringConverter
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.runBlocking
import kotlin.coroutines.experimental.CoroutineContext

class _StringConverter<T>(private val context: CoroutineContext) : StringConverter<T>() {

    private var _toString: (suspend CoroutineScope.(T?) -> String?)? = null
    private var _fromString: (suspend CoroutineScope.(String?) -> T?)? = null

    override fun toString(any: T?): String? {
        val handler = _toString ?: return it?.toString ?: null
        return runBlocking(context) { handler(any) }
    }

    override fun fromString(string: String?): T? {
        val handler = _fromString ?: return null
        return runBlocking(context) { handler(string) }
    }

    fun toString(listener: suspend CoroutineScope.(T?) -> String?) {
        _toString = listener
    }

    fun fromString(listener: suspend CoroutineScope.(String?) -> T?) {
        _fromString = listener
    }
}