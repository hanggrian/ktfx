@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.Pane

open class _Pane : Pane(), LayoutManager<Node> {

    override val childs: ObservableList<Node> get() = children
}

inline fun pane(): Pane = pane { }

inline fun pane(
    init: (@LayoutDsl _Pane).() -> Unit
): Pane = _Pane().apply(init)

inline fun LayoutManager<Node>.pane(): Pane = pane { }

inline fun LayoutManager<Node>.pane(
    init: (@LayoutDsl _Pane).() -> Unit
): Pane = ktfx.layouts.pane(init).add()