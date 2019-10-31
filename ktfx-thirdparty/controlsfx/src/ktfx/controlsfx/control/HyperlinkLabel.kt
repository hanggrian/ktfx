@file:Suppress("PackageDirectoryMismatch")

package ktfx.controlsfx

import javafx.event.ActionEvent
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode
import org.controlsfx.control.HyperlinkLabel

fun HyperlinkLabel.onAction(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Create a [HyperlinkLabel] with initialization block. */
inline fun hyperlinkLabel(
    text: String? = null,
    init: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel = HyperlinkLabel(text).apply(init)

/** Add a [HyperlinkLabel] to this manager. */
fun NodeManager.hyperlinkLabel(
    text: String? = null
): HyperlinkLabel = addNode(HyperlinkLabel(text))

/** Add a [HyperlinkLabel] with initialization block to this manager. */
inline fun NodeManager.hyperlinkLabel(
    text: String? = null,
    init: (@LayoutDslMarker HyperlinkLabel).() -> Unit
): HyperlinkLabel = addNode(HyperlinkLabel(text), init)
