@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Task.setOnScheduled
 */
inline fun Task<*>.onScheduled(noinline action: (WorkerStateEvent) -> Unit) {
    return setOnScheduled(action)
}

/**
 * @see Task.setOnRunning
 */
inline fun Task<*>.onRunning(noinline action: (WorkerStateEvent) -> Unit) {
    return setOnRunning(action)
}

/**
 * @see Task.setOnSucceeded
 */
inline fun Task<*>.onSucceeded(noinline action: (WorkerStateEvent) -> Unit) {
    return setOnSucceeded(action)
}

/**
 * @see Task.setOnCancelled
 */
inline fun Task<*>.onCancelled(noinline action: (WorkerStateEvent) -> Unit) {
    return setOnCancelled(action)
}

/**
 * @see Task.setOnFailed
 */
inline fun Task<*>.onFailed(noinline action: (WorkerStateEvent) -> Unit) {
    return setOnFailed(action)
}
