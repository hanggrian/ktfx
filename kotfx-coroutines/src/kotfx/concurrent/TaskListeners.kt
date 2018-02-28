package kotfx.concurrent

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventType
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <V, E : Event> Task<V>.eventFilter(
    context: CoroutineContext,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type, { event -> launch(context) { action(event) } })

fun <V, E : Event> Task<V>.eventHandler(
    context: CoroutineContext,
    type: EventType<E>,
    action: suspend (E) -> Unit
) = addEventHandler(type, { event -> launch(context) { action(event) } })

fun <V> Task<V>.onCancelled(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> launch(context) { action(event) } }

fun <V> Task<V>.onFailed(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnFailed { event -> launch(context) { action(event) } }

fun <V> Task<V>.onRunning(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnRunning { event -> launch(context) { action(event) } }

fun <V> Task<V>.onScheduled(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnScheduled({ event -> launch(context) { action(event) } })

fun <V> Task<V>.onSucceeded(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnSucceeded({ event -> launch(context) { action(event) } })