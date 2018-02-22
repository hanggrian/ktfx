@file:JvmMultifileClass
@file:JvmName("EventHandlersKt")

package kotfx.coroutines

import javafx.concurrent.Service
import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventType
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <V, T : Event> Service<V>.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<T>,
    action: suspend CoroutineScope.(T) -> Unit
) = addEventFilter(type) { event -> launch(context) { action(event) } }

fun <V, T : Event> Service<V>.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<T>,
    action: suspend CoroutineScope.(T) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun <V> Service<V>.onCancelled(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnCancelled { event -> launch(context) { action(event) } }

fun <V> Service<V>.onFailed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnFailed { event -> launch(context) { action(event) } }

fun <V> Service<V>.onReady(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnReady { event -> launch(context) { action(event) } }

fun <V> Service<V>.onRunning(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnRunning { event -> launch(context) { action(event) } }

fun <V> Service<V>.onScheduled(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnScheduled { event -> launch(context) { action(event) } }

fun <V> Service<V>.onSucceeded(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnSucceeded { event -> launch(context) { action(event) } }

fun <V, T : Event> Task<V>.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<T>,
    action: suspend CoroutineScope.(T) -> Unit
) = addEventFilter(type) { event -> launch(context) { action(event) } }

fun <V, T : Event> Task<V>.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<T>,
    action: suspend CoroutineScope.(T) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun <V> Task<V>.onCancelled(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnCancelled { event -> launch(context) { action(event) } }

fun <V> Task<V>.onFailed(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnFailed { event -> launch(context) { action(event) } }

fun <V> Task<V>.onRunning(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnRunning { event -> launch(context) { action(event) } }

fun <V> Task<V>.onScheduled(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnScheduled { event -> launch(context) { action(event) } }

fun <V> Task<V>.onSucceeded(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WorkerStateEvent) -> Unit
) = setOnSucceeded { event -> launch(context) { action(event) } }