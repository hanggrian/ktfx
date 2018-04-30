@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollBar

/** Creates a [ScrollBar]. */
fun scrollBar(
    init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().also {
    init?.invoke(it)
}

/** Creates a [ScrollBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.scrollBar(
    noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ktfx.layouts.scrollBar(init).add()

/** Create a styled [ScrollBar]. */
fun styledScrollBar(
    styleClass: String,
    init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ScrollBar().also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ScrollBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledScrollBar(
    styleClass: String,
    noinline init: ((@LayoutDsl ScrollBar).() -> Unit)? = null
): ScrollBar = ktfx.layouts.styledScrollBar(styleClass, init).add()