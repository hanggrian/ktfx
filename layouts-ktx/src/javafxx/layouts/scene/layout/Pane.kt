@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

open class _Pane(
    vararg children: Node
) : Pane(*children), LayoutManager<Node> {

    override val childs: MutableList<Node> get() = children
}

/** Creates a [Pane]. */
fun pane(
    vararg children: Node,
    init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = _Pane(*children).also {
    init?.invoke(it)
}

/** Creates a [Pane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.pane(
    vararg children: Node,
    noinline init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = javafxx.layouts.pane(*children, init = init)()

/** Create a styled [Pane]. */
fun styledPane(
    styleClass: String,
    vararg children: Node,
    init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = _Pane(*children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Pane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledPane(
    styleClass: String,
    vararg children: Node,
    noinline init: ((@LayoutDsl _Pane).() -> Unit)? = null
): Pane = javafxx.layouts.styledPane(styleClass, *children, init = init)()