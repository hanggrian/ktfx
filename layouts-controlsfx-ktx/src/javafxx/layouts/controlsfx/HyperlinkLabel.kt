@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.HyperlinkLabel

/** Creates a [HyperlinkLabel]. */
fun hyperlinkLabel(
    text: String? = null,
    init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = HyperlinkLabel(text).also {
    init?.invoke(it)
}

/** Creates a [HyperlinkLabel] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.hyperlinkLabel(
    text: String? = null,
    noinline init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = javafxx.layouts.controlsfx.hyperlinkLabel(text, init)()

/** Create a styled [HyperlinkLabel]. */
fun styledHyperlinkLabel(
    styleClass: String,
    text: String? = null,
    init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = HyperlinkLabel(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [HyperlinkLabel] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledHyperlinkLabel(
    styleClass: String,
    text: String? = null,
    noinline init: ((@LayoutDsl HyperlinkLabel).() -> Unit)? = null
): HyperlinkLabel = javafxx.layouts.controlsfx.styledHyperlinkLabel(styleClass, text, init)()