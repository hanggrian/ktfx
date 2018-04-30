@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.SplitPane

open class _SplitPane(
    vararg items: Node
) : SplitPane(*items), LayoutManager<Node> {

    override val childs: ObservableList<Node> get() = items
}

inline fun splitPane(
    vararg items: Node
): SplitPane = splitPane(*items) { }

inline fun splitPane(
    vararg items: Node,
    init: (@LayoutDsl _SplitPane).() -> Unit
): SplitPane = _SplitPane(*items).apply(init)

inline fun LayoutManager<Node>.splitPane(
    vararg items: Node
): SplitPane = splitPane(*items) { }

inline fun LayoutManager<Node>.splitPane(
    vararg items: Node,
    init: (@LayoutDsl _SplitPane).() -> Unit
): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()