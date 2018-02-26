@file:JvmMultifileClass
@file:JvmName("EventsKt")

package kotfx.coroutines

import javafx.event.Event
import javafx.event.EventType
import javafx.stage.PopupWindow
import javafx.stage.Window
import javafx.stage.WindowEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun PopupWindow.onAutoHide(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnAutoHide { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun <E : Event> Window.eventFilter(
    context: CoroutineContext = FX,
    type: EventType<E>,
    consume: Boolean = false,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventFilter(type) { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun <E : Event> Window.eventHandler(
    context: CoroutineContext = FX,
    type: EventType<E>,
    consume: Boolean = false,
    action: suspend CoroutineScope.(E) -> Unit
) = addEventHandler(type) { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Window.onCloseRequest(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnCloseRequest { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Window.onHidden(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnHidden { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Window.onHiding(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnHiding { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Window.onShowing(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnShowing { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}

fun Window.onShown(
    context: CoroutineContext = FX,
    consume: Boolean = false,
    action: suspend CoroutineScope.(WindowEvent) -> Unit
) = setOnShown { event ->
    if (consume) event.consume()
    launch(context) { action(event) }
}