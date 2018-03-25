package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.MenuItem
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event handler to this [MenuItem]. */
fun <E : Event> MenuItem.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

/** The action, which is invoked whenever the [MenuItem] is fired. */
fun MenuItem.onAction(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

/** The event handler that is associated with invocation of an accelerator for a [MenuItem]. */
fun MenuItem.onMenuValidation(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnMenuValidation { event -> launch(context) { action(event) } }