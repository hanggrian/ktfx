@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

inline fun pane(
    noinline init: ((@LayoutDsl Pane).() -> Unit)? = null
): Pane = Pane().also { init?.invoke(it) }

inline fun LayoutManager<Node>.pane(
    noinline init: ((@LayoutDsl Pane).() -> Unit)? = null
): Pane = ktfx.layouts.pane(init).add()