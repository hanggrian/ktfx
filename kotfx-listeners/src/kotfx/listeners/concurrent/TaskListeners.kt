@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType

inline fun <E : Event> Task<*>.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type, EventHandler(action))

inline fun <E : Event> Task<*>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun Task<*>.onCancelled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnCancelled(EventHandler(action))

inline fun Task<*>.onFailed(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnFailed(EventHandler(action))

inline fun Task<*>.onRunning(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnRunning(EventHandler(action))

inline fun Task<*>.onScheduled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnScheduled(EventHandler(action))

inline fun Task<*>.onSucceeded(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnSucceeded(EventHandler(action))