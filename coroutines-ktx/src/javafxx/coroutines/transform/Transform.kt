@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package javafxx.coroutines

/* ktlint-enable package-name */

import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.transform.Transform
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event filter to this transform. */
fun <E : Event> Transform.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventFilter(type, it) }

/** Registers an event handler to this transform. */
fun <E : Event> Transform.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> launch(context) { action(event) } }.also { addEventHandler(type, it) }