package kotfx.coroutines

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun Dialog<*>.onCloseRequest(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

fun Dialog<*>.onHidden(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun Dialog<*>.onHiding(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun Dialog<*>.onShowing(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun Dialog<*>.onShown(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }