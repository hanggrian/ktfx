@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

inline fun splitPane(
    vararg items: Node
): SplitPane = splitPane(*items) { }

inline fun splitPane(
    vararg items: Node,
    init: (@LayoutDsl SplitPane).() -> Unit
): SplitPane = SplitPane(*items).apply(init)

inline fun LayoutManager<Node>.splitPane(
    vararg items: Node
): SplitPane = splitPane(*items) { }

inline fun LayoutManager<Node>.splitPane(
    vararg items: Node,
    init: (@LayoutDsl SplitPane).() -> Unit
): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()