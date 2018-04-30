@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import ktfx.layouts.internal.MarginedPane
import ktfx.layouts.internal.VGrowedPane

open class _VBox(
    spacing: Double,
    vararg children: Node
) : VBox(spacing, *children), LayoutManager<Node>, VGrowedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.vpriority: Priority?
        get() = getVgrow(this)
        set(value) = setVgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun vbox(
    spacing: Double = 0.0,
    vararg children: Node
): VBox = vbox(spacing, *children) { }

inline fun vbox(
    spacing: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _VBox).() -> Unit
): VBox = _VBox(spacing, *children).apply(init)

inline fun LayoutManager<Node>.vbox(
    spacing: Double = 0.0,
    vararg children: Node
): VBox = vbox(spacing, *children) { }

inline fun LayoutManager<Node>.vbox(
    spacing: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _VBox).() -> Unit
): VBox = ktfx.layouts.vbox(spacing, *children, init = init).add()