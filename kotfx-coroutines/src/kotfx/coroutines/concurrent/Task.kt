package kotfx.coroutines

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventType
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> Task<*>.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type, { event -> launch(context) { action(event) } })

fun <E : Event> Task<*>.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend (E) -> Unit
) = addEventHandler(type, { event -> launch(context) { action(event) } })

fun Task<*>.onCancelled(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> launch(context) { action(event) } }

fun Task<*>.onFailed(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnFailed { event -> launch(context) { action(event) } }

fun Task<*>.onRunning(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnRunning { event -> launch(context) { action(event) } }

fun Task<*>.onScheduled(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnScheduled({ event -> launch(context) { action(event) } })

fun Task<*>.onSucceeded(
    context: CoroutineContext = FX,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnSucceeded({ event -> launch(context) { action(event) } })