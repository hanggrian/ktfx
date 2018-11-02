@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.controlsfx

import javafx.event.ActionEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import ktfx.NodeInvokable
import ktfx.LayoutDsl
import org.controlsfx.control.HyperlinkLabel
import kotlin.coroutines.CoroutineContext

fun HyperlinkLabel.onAction(
    context: CoroutineContext = kotlinx.coroutines.Dispatchers.JavaFx,
    action: suspend CoroutineScope.(ActionEvent) -> Unit
): Unit = setOnAction { event -> kotlinx.coroutines.GlobalScope.launch(context) { action(event) } }

/** Creates a [HyperlinkLabel]. */
fun hyperlinkLabel(
    text: String? = null,
    init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = HyperlinkLabel(text).also { init?.invoke(it) }

/** Creates a [HyperlinkLabel] and add it to this manager. */
inline fun NodeInvokable.hyperlinkLabel(
    text: String? = null,
    noinline init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = ktfx.controlsfx.hyperlinkLabel(text, init)()