@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

open class _SplitPane(
    vararg items: Node
) : SplitPane(*items), LayoutManager<Node> {

    override val childs: MutableList<Node> get() = items
}

/** Creates a [SplitPane]. */
fun splitPane(
    vararg items: Node,
    init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = _SplitPane(*items).also {
    init?.invoke(it)
}

/** Creates a [SplitPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.splitPane(
    vararg items: Node,
    noinline init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()

/** Create a styled [SplitPane]. */
fun styledSplitPane(
    styleClass: String,
    vararg items: Node,
    init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = _SplitPane(*items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [SplitPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSplitPane(
    styleClass: String,
    vararg items: Node,
    noinline init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.styledSplitPane(styleClass, *items, init = init).add()