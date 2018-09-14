@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.Task

/** Receiver in [buildService], invoke [call] to customize what this Task do in the background. */
class _Task<V> : Task<V>() {
    private var _onCall: (() -> V?) = { null }

    fun call(onCall: () -> V?) {
        _onCall = onCall
    }

    override fun call(): V? = _onCall()
}

/**
 * Returns a [Service] by invoking [Task] DSL.
 * By default, it will do nothing and returns null in the background, customize it by invoking `call`.
 */
fun <V> buildService(
    builderAction: (_Task<V>).() -> Unit = {}
): Service<V> {
    val task = _Task<V>().also(builderAction)
    return object : Service<V>() {
        override fun createTask(): Task<V> = task
    }
}