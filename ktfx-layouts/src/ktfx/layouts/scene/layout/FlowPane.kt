@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.layout.FlowPane
import ktfx.layouts.internal.MarginedPane

open class _FlowPane(
    orientation: Orientation,
    hgap: Double,
    vgap: Double,
    vararg children: Node
) : FlowPane(orientation, hgap, vgap, *children), LayoutManager<Node>, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node
): FlowPane = flowPane(orientation, hgap, vgap, *children) { }

inline fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _FlowPane).() -> Unit
): FlowPane = _FlowPane(orientation, hgap, vgap, *children).apply(init)

inline fun LayoutManager<Node>.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node
): FlowPane = flowPane(orientation, hgap, vgap, *children) { }

inline fun LayoutManager<Node>.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _FlowPane).() -> Unit
): FlowPane = ktfx.layouts.flowPane(orientation, hgap, vgap, *children, init = init).add()