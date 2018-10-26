@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** The button's action, which is invoked whenever the button is fired. */
fun ButtonBase.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }