package ktfx.coroutines

import javafx.scene.control.Dialog
import javafx.scene.control.DialogEvent
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Called when there is an external request to close this [Dialog]. */
fun Dialog<*>.onCloseRequest(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnCloseRequest { event -> launch(context) { action(event) } }

/** Called just after the [Dialog] has been hidden. */
fun Dialog<*>.onHidden(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

/** Called just prior to the [Dialog] being hidden. */
fun Dialog<*>.onHiding(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

/** Called just prior to the [Dialog] being shown. */
fun Dialog<*>.onShowing(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

/** Called just after the [Dialog] is shown. */
fun Dialog<*>.onShown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(DialogEvent) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }