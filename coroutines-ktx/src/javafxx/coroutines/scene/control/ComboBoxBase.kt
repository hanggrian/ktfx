package javafxx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBoxBase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** The ComboBox action, which is invoked whenever the [ComboBoxBase.valueProperty] property is changed. */
fun ComboBoxBase<*>.onAction(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }

/** Called just after the [ComboBoxBase] popup/display has been hidden. */
fun ComboBoxBase<*>.onHidden(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHidden { event -> launch(context) { action(event) } }

/** Called just after the [ComboBoxBase] popup/display is shown. */
fun ComboBoxBase<*>.onHiding(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnHiding { event -> launch(context) { action(event) } }

/** Called just prior to the [ComboBoxBase] popup/display being shown. */
fun ComboBoxBase<*>.onShowing(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShowing { event -> launch(context) { action(event) } }

/** Called just after the [ComboBoxBase] popup/display is shown. */
fun ComboBoxBase<*>.onShown(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(Event) -> Unit
) = setOnShown { event -> launch(context) { action(event) } }