@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.concurrent.Task
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this task. */
fun <E : Event> Task<*>.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventFilter(type, it) }

/** Registers an event handler to this task. */
fun <E : Event> Task<*>.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend (E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventHandler(type, it) }

/** The onCancelled event handler is called whenever the Task state transitions to the CANCELLED state. */
fun Task<*>.onCancelled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnCancelled { event -> GlobalScope.launch(context) { action(event) } }

/** The onFailed event handler is called whenever the Task state transitions to the FAILED state. */
fun Task<*>.onFailed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnFailed { event -> GlobalScope.launch(context) { action(event) } }

/** The onRunning event handler is called whenever the Task state transitions to the RUNNING state. */
fun Task<*>.onRunning(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnRunning { event -> GlobalScope.launch(context) { action(event) } }

/** The onSchedule event handler is called whenever the Task state transitions to the SCHEDULED state. */
fun Task<*>.onScheduled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnScheduled { event -> GlobalScope.launch(context) { action(event) } }

/** The onSucceeded event handler is called whenever the Task state transitions to the SUCCEEDED state. */
fun Task<*>.onSucceeded(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
) = setOnSucceeded { event -> GlobalScope.launch(context) { action(event) } }