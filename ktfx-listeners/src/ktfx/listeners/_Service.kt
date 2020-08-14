@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

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
inline fun Service<*>.onReady(noinline action: (WorkerStateEvent) -> Unit): Unit =
    setOnReady(action)

/**
 * @see Service.setOnScheduled
 */
inline fun Service<*>.onScheduled(noinline action: (WorkerStateEvent) -> Unit): Unit =
    setOnScheduled(action)

/**
 * @see Service.setOnRunning
 */
inline fun Service<*>.onRunning(noinline action: (WorkerStateEvent) -> Unit): Unit =
    setOnRunning(action)

/**
 * @see Service.setOnSucceeded
 */
inline fun Service<*>.onSucceeded(noinline action: (WorkerStateEvent) -> Unit): Unit =
    setOnSucceeded(action)

/**
 * @see Service.setOnCancelled
 */
inline fun Service<*>.onCancelled(noinline action: (WorkerStateEvent) -> Unit): Unit =
    setOnCancelled(action)

/**
 * @see Service.setOnFailed
 */
inline fun Service<*>.onFailed(noinline action: (WorkerStateEvent) -> Unit): Unit =
    setOnFailed(action)
