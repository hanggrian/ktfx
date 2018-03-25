package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** The button's action, which is invoked whenever the button is fired. */
fun ButtonBase.onAction(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
) = setOnAction { event -> launch(context) { action(event) } }