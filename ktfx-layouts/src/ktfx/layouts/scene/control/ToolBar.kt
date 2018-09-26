@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ToolBar

open class _ToolBar(
    vararg items: Node
) : ToolBar(*items), LayoutManager<Node> {

    override val childs: MutableCollection<Node> get() = items
}

/** Creates a [ToolBar]. */
fun toolBar(
    vararg items: Node,
    init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar(*items).also {
    init?.invoke(it)
}

/** Creates a [ToolBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.toolBar(
    vararg items: Node,
    noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = ktfx.layouts.toolBar(*items, init = init)()

/** Create a styled [ToolBar]. */
fun styledToolBar(
    styleClass: String,
    vararg items: Node,
    init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar(*items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [ToolBar] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledToolBar(
    styleClass: String,
    vararg items: Node,
    noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = ktfx.layouts.styledToolBar(styleClass, *items, init = init)()