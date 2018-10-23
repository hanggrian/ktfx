package ktfx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.Task
import ktfx.internal.KtfxTask

/**
 * Returns a [Service] by invoking [Task] DSL.
 * By default, it will do nothing and returns null in the background, customize it by invoking `call`.
 */
fun <V> buildService(builderAction: KtfxTask<V>.() -> Unit): Service<V> {
    val task = KtfxTask<V>().also(builderAction)
    return object : Service<V>() {
        override fun createTask(): Task<V> = task
    }
}