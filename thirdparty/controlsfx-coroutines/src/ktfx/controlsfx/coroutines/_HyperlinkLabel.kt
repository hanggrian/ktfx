@file:JvmMultifileClass
@file:JvmName("ControlsFxCoroutinesKt")

package ktfx.controlsfx.coroutines

import javafx.event.ActionEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import org.controlsfx.control.HyperlinkLabel
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see HyperlinkLabel.setOnAction
 */
fun HyperlinkLabel.onAction(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(ActionEvent) -> Unit
) {
    return setOnAction { event -> GlobalScope.launch(context) { action(event) } }
}
