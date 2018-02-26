@file:JvmMultifileClass
@file:JvmName("EventsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventType

inline fun <V, T : Event> Service<V>.eventFilter(
    type: EventType<T>,
    noinline action: (T) -> Unit
) = addEventFilter(type) { event -> action(event) }

inline fun <V, T : Event> Service<V>.eventHandler(
    type: EventType<T>,
    noinline action: (T) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun <V> Service<V>.onCancelled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> action(event) }

inline fun <V> Service<V>.onFailed(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnFailed { event -> action(event) }

inline fun <V> Service<V>.onReady(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnReady { event -> action(event) }

inline fun <V> Service<V>.onRunning(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnRunning { event -> action(event) }

inline fun <V> Service<V>.onScheduled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnScheduled { event -> action(event) }

inline fun <V> Service<V>.onSucceeded(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnSucceeded { event -> action(event) }

inline fun <V, T : Event> Task<V>.eventFilter(
    type: EventType<T>,
    noinline action: (T) -> Unit
) = addEventFilter(type) { event -> action(event) }

inline fun <V, T : Event> Task<V>.eventHandler(
    type: EventType<T>,
    noinline action: (T) -> Unit
) = addEventHandler(type) { event -> action(event) }

inline fun <V> Task<V>.onCancelled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> action(event) }

inline fun <V> Task<V>.onFailed(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnFailed { event -> action(event) }

inline fun <V> Task<V>.onRunning(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnRunning { event -> action(event) }

inline fun <V> Task<V>.onScheduled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnScheduled { event -> action(event) }

inline fun <V> Task<V>.onSucceeded(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnSucceeded { event -> action(event) }