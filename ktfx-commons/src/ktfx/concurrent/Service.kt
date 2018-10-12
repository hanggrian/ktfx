package ktfx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.Task
import ktfx.internal._Task

/**
 * Returns a [Service] by invoking [Task] DSL.
 * By default, it will do nothing and returns null in the background, customize it by invoking `call`.
 */
fun <V> buildService(builderAction: _Task<V>.() -> Unit = { }): Service<V> {
    val task = _Task<V>().also(builderAction)
    return object : Service<V>() {
        override fun createTask(): Task<V> = task
    }
}