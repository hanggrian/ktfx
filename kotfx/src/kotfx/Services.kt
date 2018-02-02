@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.concurrent.Service
import javafx.concurrent.Task

abstract class _Task<V> : Task<V>() {
    fun progress(workDone: Number, max: Number) = updateProgress(workDone.toDouble(), max.toDouble())
    fun message(message: String?) = updateMessage(message)
    fun title(title: String?) = updateTitle(title)
    fun value(value: V?) = updateValue(value)
}

@JvmOverloads
fun <V> service(
        onCall: _Task<V>.() -> V,
        init: (Service<V>.() -> Unit)? = null
): Service<V> = object : Service<V>() {
    override fun createTask(): Task<V> = object : _Task<V>() {
        override fun call(): V = onCall(this)
    }
}.apply { init?.invoke(this) }