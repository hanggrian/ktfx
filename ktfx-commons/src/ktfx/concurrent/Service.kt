package ktfx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.Task

/** Receiver in `ktfx.concurrent.buildService`, invoke [call] to customize what this Task do in the background. */
@Suppress("ClassName")
class _Task<V> : Task<V>() {

    private var _call: () -> V? = { null }

    fun call(onCall: () -> V?) {
        _call = onCall
    }

    override fun call(): V? = _call()
}

/**
 * Returns a [Service] by invoking [Task] DSL.
 * By default, it will do nothing and returns null in the background, customize it by invoking `call`.
 */
fun <V> buildService(builderAction: _Task<V>.() -> Unit): Service<V> {
    val task = _Task<V>().also(builderAction)
    return object : Service<V>() {
        override fun createTask(): Task<V> = task
    }
}