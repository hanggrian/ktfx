@file:JvmMultifileClass
@file:JvmName("ControlsFxCoroutinesKt")

package ktfx.controlsfx.coroutines

import javafx.event.ActionEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.HyperlinkLabel

/** Sets a new EventHandler which will be invoked whenever a hyperlink is fired. */
fun HyperlinkLabel.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> GlobalScope.launch(context) { action(event) } }
