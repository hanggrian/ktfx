@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import ktfx.layouts.internal.HGrowedPane
import ktfx.layouts.internal.MarginedPane

open class _HBox(
    spacing: Double,
    vararg children: Node
) : HBox(spacing, *children), LayoutManager<Node>, HGrowedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.hpriority: Priority?
        get() = getHgrow(this)
        set(value) = setHgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [HBox]. */
inline fun hbox(
    spacing: Double = 0.0,
    vararg children: Node
): HBox = hbox(spacing, *children) { }

/** Create a [HBox] with initialization. */
inline fun hbox(
    spacing: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _HBox).() -> Unit
): HBox = _HBox(spacing, *children).apply(init)

/** Create a [HBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.hbox(
    spacing: Double = 0.0,
    vararg children: Node
): HBox = hbox(spacing, *children) { }

/** Create a [HBox] with initialization and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.hbox(
    spacing: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _HBox).() -> Unit
): HBox = ktfx.layouts.hbox(spacing, *children, init = init).add()