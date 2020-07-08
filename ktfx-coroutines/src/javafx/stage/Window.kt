@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Registers an event filter to this node. */
fun <E : Event> Window.eventFilter(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
fun <E : Event> Window.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventHandler(type, it) }

/** Called when there is an external request to close this [Window]. */
fun Window.onCloseRequest(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnCloseRequest { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [Window] being shown. */
fun Window.onShowing(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnShowing { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the Window is shown. */
fun Window.onShown(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnShown { event -> GlobalScope.launch(context) { action(event) } }

/** Called just prior to the [Window] being hidden. */
fun Window.onHiding(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnHiding { event -> GlobalScope.launch(context) { action(event) } }

/** Called just after the [Window] has been hidden. */
fun Window.onHidden(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
): Unit = setOnHidden { event -> GlobalScope.launch(context) { action(event) } }
