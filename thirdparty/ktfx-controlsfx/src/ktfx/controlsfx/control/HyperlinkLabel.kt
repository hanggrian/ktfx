@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.HyperlinkLabel

/** Creates a [HyperlinkLabel]. */
fun hyperlinkLabel(
    text: String? = null,
    init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = HyperlinkLabel(text).also { init?.invoke(it) }

/** Creates a [HyperlinkLabel] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.hyperlinkLabel(
    text: String? = null,
    noinline init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = ktfx.controlsfx.hyperlinkLabel(text, init)()