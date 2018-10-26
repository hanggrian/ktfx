@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.MenuItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Registers an event handler to this [MenuItem]. */
fun <E : Event> MenuItem.eventHandler(
    context: CoroutineContext = Dispatchers.JavaFx,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
): EventHandler<E> = EventHandler<E> { event -> GlobalScope.launch(context) { action(event) } }
    .also { addEventHandler(type, it) }

/** The action, which is invoked whenever the [MenuItem] is fired. */
fun MenuItem.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }

/** The event handler that is associated with invocation of an accelerator for a [MenuItem]. */
fun MenuItem.onMenuValidation(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(Event) -> Unit
): Unit = setOnMenuValidation { event -> GlobalScope.launch(context) { action(event) } }