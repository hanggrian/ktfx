package ktfx.coroutines

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this task. */
fun <E : Event> Service<*>.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend (E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventFilter(type, it) }

/** Registers an event filter to this task. */
fun <E : Event> Service<*>.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend (E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventHandler(type, it) }

/** The onCancelled event handler is called whenever the Task state transitions to the CANCELLED state. */
fun Service<*>.onCancelled(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> launch(context) { action(event) } }

/** The onFailed event handler is called whenever the Task state transitions to the FAILED state. */
fun Service<*>.onFailed(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnFailed { event -> launch(context) { action(event) } }

/** The onReady event handler is called whenever the Task state transitions to the READY state. */
fun Service<*>.onReady(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnReady { event -> launch(context) { action(event) } }

/** The onRunning event handler is called whenever the Task state transitions to the RUNNING state. */
fun Service<*>.onRunning(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnRunning { event -> launch(context) { action(event) } }

/** The onSchedule event handler is called whenever the Task state transitions to the SCHEDULED state. */
fun Service<*>.onScheduled(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnScheduled { event -> launch(context) { action(event) } }

/** The onSucceeded event handler is called whenever the Task state transitions to the SUCCEEDED state. */
fun Service<*>.onSucceeded(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnSucceeded { event -> launch(context) { action(event) } }