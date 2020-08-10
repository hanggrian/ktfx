@file:JvmMultifileClass
@file:JvmName("ControlsfxCoroutinesKt")

package ktfx.controlsfx.coroutines

import javafx.event.ActionEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.HyperlinkLabel
import kotlin.coroutines.CoroutineContext

/** Sets a new EventHandler which will be invoked whenever a hyperlink is fired. */
fun HyperlinkLabel.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }