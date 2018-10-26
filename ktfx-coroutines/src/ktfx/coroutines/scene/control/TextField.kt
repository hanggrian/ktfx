@file:Suppress("PackageDirectoryMismatch")

package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** The action handler associated with this text field, or `null` if no action handler is assigned. */
fun TextField.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }