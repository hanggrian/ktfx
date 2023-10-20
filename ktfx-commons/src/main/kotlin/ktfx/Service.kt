package ktfx

import javafx.concurrent.Service
import javafx.concurrent.Task

/**
 * Receiver in `ktfx.buildService`, invoke [call] to customize what this Task do in the background.
 */
class TaskBuilder<V> internal constructor() : Task<V>() {
    private var call: () -> V? = { null }

    fun call(onCall: () -> V?) {
        call = onCall
    }

    override fun call(): V? = call()
}

/**
 * Returns a [Service] by invoking [Task] DSL. By default, it will do nothing and returns null in
 * the background, customize it by invoking `call`.
 */
fun <V> buildService(builderAction: TaskBuilder<V>.() -> Unit): Service<V> =
    object : Service<V>() {
        override fun createTask(): Task<V> = TaskBuilder<V>().apply(builderAction)
    }
