@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this node. */
fun <E : Event> Window.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventFilter(type, it) }

/** Registers an event handler to this node. */
fun <E : Event> Window.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventHandler(type, it) }

/** Called when there is an external request to close this [Window]. */
fun Window.onCloseRequest(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

/** Called just after the [Window] has been hidden. */
fun Window.onHidden(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

/** Called just prior to the [Window] being hidden. */
fun Window.onHiding(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

/** Called just prior to the [Window] being shown. */
fun Window.onShowing(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

/** Called just after the Window is shown. */
fun Window.onShown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }