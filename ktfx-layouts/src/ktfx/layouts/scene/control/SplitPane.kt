@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

inline fun splitPane(
    vararg items: Node,
    noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null
): SplitPane = SplitPane(*items).also { init?.invoke(it) }

inline fun LayoutManager<Node>.splitPane(
    vararg items: Node,
    noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()