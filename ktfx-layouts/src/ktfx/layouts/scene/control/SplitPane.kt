@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

inline fun splitPane(vararg items: Node, noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null): SplitPane = SplitPane(*items).apply { init?.invoke(this) }

inline fun Manager<Node>.splitPane(vararg items: Node, noinline init: ((@LayoutDsl SplitPane).() -> Unit)? = null): SplitPane = ktfx.layouts.splitPane(*items, init = init).add()