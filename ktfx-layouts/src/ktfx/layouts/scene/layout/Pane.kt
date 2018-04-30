@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.layout.Pane

open class _Pane(
    vararg children: Node
) : Pane(*children), LayoutManager<Node> {

    override val childs: ObservableList<Node> get() = children
}

/** Create a [Pane]. */
inline fun pane(
    vararg children: Node
): Pane = pane(*children) { }

/** Create a [Pane] with initialization. */
inline fun pane(
    vararg children: Node,
    init: (@LayoutDsl _Pane).() -> Unit
): Pane = _Pane(*children).apply(init)

/** Create a [Pane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.pane(
    vararg children: Node
): Pane = pane(*children) { }

/** Create a [Pane] with initialization and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.pane(
    vararg children: Node,
    init: (@LayoutDsl _Pane).() -> Unit
): Pane = ktfx.layouts.pane(*children, init = init).add()