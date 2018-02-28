package kotfx.concurrent

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventType
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <V, E : Event> Service<V>.eventFilter(
    context: CoroutineContext,
    type: EventType<E>,
    action: (E) -> Unit
) = addEventFilter(type, { event -> launch(context) { action(event) } })

fun <V, E : Event> Service<V>.eventHandler(
    context: CoroutineContext,
    type: EventType<E>,
    action: (E) -> Unit
) = addEventFilter(type, { event -> launch(context) { action(event) } })

fun <V> Service<V>.onCancelled(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> launch(context) { action(event) } }

fun <V> Service<V>.onFailed(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnFailed { event -> launch(context) { action(event) } }

fun <V> Service<V>.onReady(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnReady { event -> launch(context) { action(event) } }

fun <V> Service<V>.onRunning(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnRunning { event -> launch(context) { action(event) } }

fun <V> Service<V>.onScheduled(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnScheduled { event -> launch(context) { action(event) } }

fun <V> Service<V>.onSucceeded(
    context: CoroutineContext,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnSucceeded { event -> launch(context) { action(event) } }