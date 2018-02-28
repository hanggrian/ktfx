package kotfx.scene.control

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ComboBoxBase<T>.onAction(
    context: CoroutineContext,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onHidden(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onHiding(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onShowing(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun <T> ComboBoxBase<T>.onShown(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }