@file:Suppress("PackageDirectoryMismatch")

package ktfx.thirdparty.controlsfx.coroutines

import javafx.event.ActionEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.HyperlinkLabel
import kotlin.coroutines.CoroutineContext

fun HyperlinkLabel.onAction(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }
