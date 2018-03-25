package ktfx.coroutines

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.TreeItem
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Registers an event handler to this [TreeItem]. */
fun <E : Event> TreeItem<*>.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }