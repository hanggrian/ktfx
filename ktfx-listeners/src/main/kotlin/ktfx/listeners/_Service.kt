@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

package ktfx.listeners

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see Service.setOnReady
 */
public inline fun Service<*>.onReady(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnReady(action)

/**
 * @see Service.setOnScheduled
 */
public inline fun Service<*>.onScheduled(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnScheduled(action)

/**
 * @see Service.setOnRunning
 */
public inline fun Service<*>.onRunning(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnRunning(action)

/**
 * @see Service.setOnSucceeded
 */
public inline fun Service<*>.onSucceeded(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnSucceeded(action)

/**
 * @see Service.setOnCancelled
 */
public inline fun Service<*>.onCancelled(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnCancelled(action)

/**
 * @see Service.setOnFailed
 */
public inline fun Service<*>.onFailed(noinline action: (WorkerStateEvent) -> Unit): Unit =
        setOnFailed(action)
