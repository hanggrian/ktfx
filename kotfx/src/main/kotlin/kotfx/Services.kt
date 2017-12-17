@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.concurrent.Service
import javafx.concurrent.Task
import kotfx.internal.ServiceDsl

abstract class _Task<V> : Task<V>() {
    fun progress(workDone: Number, max: Number) = updateProgress(workDone.toDouble(), max.toDouble())
    fun message(message: String?) = updateMessage(message)
    fun title(title: String?) = updateTitle(title)
    fun value(value: V?) = updateValue(value)
}

@JvmOverloads
inline fun <V> service(
        noinline onCall: _Task<V>.() -> V,
        noinline init: ((@ServiceDsl Service<V>).() -> Unit)? = null
): Service<V> = object : Service<V>() {
    override fun createTask(): Task<V> = object : _Task<V>() {
        override fun call(): V = onCall(this)
    }
}.apply { init?.invoke(this) }