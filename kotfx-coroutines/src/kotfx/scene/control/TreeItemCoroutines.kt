package kotfx.scene.control

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.TreeItem
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> TreeItem<*>.eventHandler(
    context: CoroutineContext,
    type: EventType<E>,
    action: suspend CoroutineScope.(Event) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }