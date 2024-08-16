@file:OptIn(ExperimentalContracts::class)

package ktfx

import javafx.concurrent.Service
import javafx.concurrent.Task
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 * Receiver in `ktfx.buildService`, invoke [call] to customize what this Task do in the background.
 */
public class TaskBuilder<V> : Task<V>() {
    private var call: () -> V? = { null }

    public fun call(onCall: () -> V?) {
        call = onCall
    }

    override fun call(): V? = call()
}

/**
 * Returns a [Service] by invoking [Task] DSL. By default, it will do nothing and returns null in
 * the background, customize it by invoking `call`.
 */
public inline fun <V> buildService(builderAction: TaskBuilder<V>.() -> Unit): Service<V> {
    contract { callsInPlace(builderAction, InvocationKind.EXACTLY_ONCE) }
    val task = TaskBuilder<V>().apply(builderAction)
    return object : Service<V>() {
        override fun createTask(): Task<V> = task
    }
}
