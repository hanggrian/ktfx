package ktfx.coroutines

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventType
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this task. */
fun <E : Event> Task<*>.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type, { event -> launch(context) { action(event) } })

/** Registers an event handler to this task. */
fun <E : Event> Task<*>.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend (E) -> Unit
) = addEventHandler(type, { event -> launch(context) { action(event) } })

/** The onCancelled event handler is called whenever the Task state transitions to the CANCELLED state. */
fun Task<*>.onCancelled(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> launch(context) { action(event) } }

/** The onFailed event handler is called whenever the Task state transitions to the FAILED state. */
fun Task<*>.onFailed(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnFailed { event -> launch(context) { action(event) } }

/** The onRunning event handler is called whenever the Task state transitions to the RUNNING state. */
fun Task<*>.onRunning(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnRunning { event -> launch(context) { action(event) } }

/** The onSchedule event handler is called whenever the Task state transitions to the SCHEDULED state. */
fun Task<*>.onScheduled(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnScheduled({ event -> launch(context) { action(event) } })

/** The onSucceeded event handler is called whenever the Task state transitions to the SUCCEEDED state. */
fun Task<*>.onSucceeded(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnSucceeded({ event -> launch(context) { action(event) } })