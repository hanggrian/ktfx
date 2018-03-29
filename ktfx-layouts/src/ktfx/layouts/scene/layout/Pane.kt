@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Pane

inline fun pane(): Pane = pane { }
inline fun pane(
    init: (@LayoutDsl Pane).() -> Unit
): Pane = Pane().apply(init)

inline fun LayoutManager<Node>.pane(): Pane = pane { }
inline fun LayoutManager<Node>.pane(
    init: (@LayoutDsl Pane).() -> Unit
): Pane = ktfx.layouts.pane(init).add()