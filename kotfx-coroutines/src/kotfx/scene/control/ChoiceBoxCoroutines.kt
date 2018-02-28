package kotfx.scene.control

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun <T> ChoiceBox<T>.onAction(
    context: CoroutineContext,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onHidden(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onHiding(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onShowing(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

fun <T> ChoiceBox<T>.onShown(
    context: CoroutineContext,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }