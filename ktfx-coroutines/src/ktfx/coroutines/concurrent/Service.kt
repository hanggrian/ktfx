@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.concurrent.Service
import javafx.concurrent.WorkerStateEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this task. */
fun <E : Event> Service<*>.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend (E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventFilter(type, it) }

/** Registers an event filter to this task. */
fun <E : Event> Service<*>.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend (E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventHandler(type, it) }

/** The onCancelled event handler is called whenever the Task state transitions to the CANCELLED state. */
fun Service<*>.onCancelled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
): Unit = setOnCancelled { event -> GlobalScope.launch(context) { action(event) } }

/** The onFailed event handler is called whenever the Task state transitions to the FAILED state. */
fun Service<*>.onFailed(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
): Unit = setOnFailed { event -> GlobalScope.launch(context) { action(event) } }

/** The onReady event handler is called whenever the Task state transitions to the READY state. */
fun Service<*>.onReady(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
): Unit = setOnReady { event -> GlobalScope.launch(context) { action(event) } }

/** The onRunning event handler is called whenever the Task state transitions to the RUNNING state. */
fun Service<*>.onRunning(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
): Unit = setOnRunning { event -> GlobalScope.launch(context) { action(event) } }

/** The onSchedule event handler is called whenever the Task state transitions to the SCHEDULED state. */
fun Service<*>.onScheduled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
): Unit = setOnScheduled { event -> GlobalScope.launch(context) { action(event) } }

/** The onSucceeded event handler is called whenever the Task state transitions to the SUCCEEDED state. */
fun Service<*>.onSucceeded(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend (WorkerStateEvent) -> Unit
): Unit = setOnSucceeded { event -> GlobalScope.launch(context) { action(event) } }