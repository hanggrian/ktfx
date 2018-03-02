package kotfx.coroutines

import javafx.event.Event
import javafx.event.EventType
import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <E : Event> Window.eventFilter(
    context: CoroutineContext,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type) { event -> launch(context) { action(event) } }

fun <E : Event> Window.eventHandler(
    context: CoroutineContext,
    type: EventType<E>,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event -> launch(context) { action(event) } }

fun Window.onCloseRequest(
    context: CoroutineContext,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

fun Window.onHidden(
    context: CoroutineContext,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun Window.onHiding(
    context: CoroutineContext,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun Window.onShowing(
    context: CoroutineContext,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun Window.onShown(
    context: CoroutineContext,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }