package ktfx.coroutines

import javafx.event.Event
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
) = addEventFilter(type) { event -> launch(context) { action(event) } }

/** Registers an event handler to this transform. */
fun <E : Event> Transform.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }