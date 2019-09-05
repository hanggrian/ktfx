@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.event.ActionEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.HyperlinkLabel

fun HyperlinkLabel.onAction(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Add a [HyperlinkLabel] to this manager. */
fun NodeManager.hyperlinkLabel(
    text: String? = null
): HyperlinkLabel = HyperlinkLabel(text).add()

/** Add a [HyperlinkLabel] with initialization block to this manager. */
inline fun NodeManager.hyperlinkLabel(
    text: String? = null,
    init: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel = hyperlinkLabel(text).apply(init)
