@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType

/** Registers an event filter to this task. */
inline fun <E : Event> Task<*>.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventFilter(type, it) }

/** Registers an event handler to this task. */
inline fun <E : Event> Task<*>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
): EventHandler<E> = EventHandler(action)
    .also { addEventHandler(type, it) }

/** The onSchedule event handler is called whenever the Task state transitions to the SCHEDULED state. */
inline fun Task<*>.onScheduled(
    noinline action: (WorkerStateEvent) -> Unit
): Unit = setOnScheduled(action)

/** The onRunning event handler is called whenever the Task state transitions to the RUNNING state. */
inline fun Task<*>.onRunning(
    noinline action: (WorkerStateEvent) -> Unit
): Unit = setOnRunning(action)

/** The onSucceeded event handler is called whenever the Task state transitions to the SUCCEEDED state. */
inline fun Task<*>.onSucceeded(
    noinline action: (WorkerStateEvent) -> Unit
): Unit = setOnSucceeded(action)

/** The onCancelled event handler is called whenever the Task state transitions to the CANCELLED state. */
inline fun Task<*>.onCancelled(
    noinline action: (WorkerStateEvent) -> Unit
): Unit = setOnCancelled(action)

/** The onFailed event handler is called whenever the Task state transitions to the FAILED state. */
inline fun Task<*>.onFailed(
    noinline action: (WorkerStateEvent) -> Unit
): Unit = setOnFailed(action)
