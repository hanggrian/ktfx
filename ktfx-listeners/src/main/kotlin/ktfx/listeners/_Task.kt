@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

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
public inline fun Task<*>.onScheduled(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnScheduled(action)

/**
 * @see Task.setOnRunning
 */
public inline fun Task<*>.onRunning(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnRunning(action)

/**
 * @see Task.setOnSucceeded
 */
public inline fun Task<*>.onSucceeded(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnSucceeded(action)

/**
 * @see Task.setOnCancelled
 */
public inline fun Task<*>.onCancelled(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnCancelled(action)

/**
 * @see Task.setOnFailed
 */
public inline fun Task<*>.onFailed(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnFailed(action)
