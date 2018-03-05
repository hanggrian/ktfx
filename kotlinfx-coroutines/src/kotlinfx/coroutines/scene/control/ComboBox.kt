package kotlinfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun ComboBoxBase<*>.onAction(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun ComboBoxBase<*>.onHidden(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun ComboBoxBase<*>.onHiding(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun ComboBoxBase<*>.onShowing(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun ComboBoxBase<*>.onShown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }