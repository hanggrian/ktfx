@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink

/** Creates a [Hyperlink]. */
fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = Hyperlink(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [Hyperlink] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = javafxx.layouts.hyperlink(text, graphic, init)()

/** Create a styled [Hyperlink]. */
fun styledHyperlink(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = Hyperlink(text, graphic).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Hyperlink] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledHyperlink(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = javafxx.layouts.styledHyperlink(styleClass, text, graphic, init)()