@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType

inline fun <E : Event> Service<*>.eventFilter(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventFilter(type, EventHandler(action))

inline fun <E : Event> Service<*>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun Service<*>.onCancelled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnCancelled(EventHandler(action))

inline fun Service<*>.onFailed(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnFailed(EventHandler(action))

inline fun Service<*>.onReady(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnReady(EventHandler(action))

inline fun Service<*>.onRunning(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnRunning(EventHandler(action))

inline fun Service<*>.onScheduled(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnScheduled(EventHandler(action))

inline fun Service<*>.onSucceeded(
    noinline action: (WorkerStateEvent) -> Unit
) = setOnSucceeded(EventHandler(action))