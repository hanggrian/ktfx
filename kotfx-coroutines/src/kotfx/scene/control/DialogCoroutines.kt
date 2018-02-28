package kotfx.scene.control

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <R> Dialog<R>.onCloseRequest(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onHidden(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onHiding(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onShowing(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun <R> Dialog<R>.onShown(
    context: CoroutineContext,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }