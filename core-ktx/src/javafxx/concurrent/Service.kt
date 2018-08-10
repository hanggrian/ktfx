@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.Task

class _Task<V> : Task<V>() {
    private var onCall: (() -> V?) = { null }

    fun call(call: () -> V?) {
        onCall = call
    }

    override fun call(): V? = onCall()
}

/**
 * Returns a [Service] by invoking [Task] DSL.
 * By default, it will do nothing and returns null in the background, customize it by invoking `call`.
 */
inline fun <V> buildService(
    listener: (_Task<V>).() -> Unit = {}
): Service<V> {
    val task = _Task<V>().also(listener)
    return object : Service<V>() {
        override fun createTask(): Task<V> = task
    }
}