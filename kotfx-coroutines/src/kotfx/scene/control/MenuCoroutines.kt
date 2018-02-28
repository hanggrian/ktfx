package kotfx.scene.control

import javafx.event.Event
import javafx.event.EventType
import javafx.scene.control.Menu
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> Menu.eventHandler(
    context: CoroutineContext,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun Menu.onHidden(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun Menu.onHiding(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun Menu.onShowing(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun Menu.onShown(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }