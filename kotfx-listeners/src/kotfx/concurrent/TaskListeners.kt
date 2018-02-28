@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.concurrent

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType

inline fun <V, E : Event> Task<V>.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type, EventHandler(action))

inline fun <V, E : Event> Task<V>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun <V> Task<V>.onCancelled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnCancelled(EventHandler(action))

inline fun <V> Task<V>.onFailed(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnFailed(EventHandler(action))

inline fun <V> Task<V>.onRunning(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnRunning(EventHandler(action))

inline fun <V> Task<V>.onScheduled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnScheduled(EventHandler(action))

inline fun <V> Task<V>.onSucceeded(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnSucceeded(EventHandler(action))