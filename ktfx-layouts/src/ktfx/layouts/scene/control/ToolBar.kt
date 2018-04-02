@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ToolBar

@Suppress("ClassName")
open class _ToolBar(vararg items: Node) : ToolBar(*items), LayoutManager<Node> {

    override val childs: ObservableList<Node> get() = items
}

inline fun toolBar(
    vararg items: Node
): ToolBar = toolBar(*items) { }

inline fun toolBar(
    vararg items: Node,
    init: (@LayoutDsl _ToolBar).() -> Unit
): ToolBar = _ToolBar(*items).apply(init)

inline fun LayoutManager<Node>.toolBar(
    vararg items: Node
): ToolBar = toolBar(*items) { }

inline fun LayoutManager<Node>.toolBar(
    vararg items: Node,
    init: (@LayoutDsl _ToolBar).() -> Unit
): ToolBar = ktfx.layouts.toolBar(*items, init = init).add()