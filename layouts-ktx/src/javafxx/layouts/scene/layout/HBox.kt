@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package javafxx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafxx.layouts.internal.HGrowedPane
import javafxx.layouts.internal.MarginedPane

open class _HBox(
    spacing: Double,
    vararg children: Node
) : HBox(spacing, *children), LayoutManager<Node>, HGrowedPane, MarginedPane {

    override val childs: MutableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.hpriority: Priority?
        get() = getHgrow(this)
        set(value) = setHgrow(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [HBox]. */
fun hbox(
    spacing: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _HBox).() -> Unit)? = null
): HBox = _HBox(spacing, *children).also {
    init?.invoke(it)
}

/** Creates a [HBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.hbox(
    spacing: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _HBox).() -> Unit)? = null
): HBox = javafxx.layouts.hbox(spacing, *children, init = init)()

/** Create a styled [HBox]. */
fun styledHbox(
    styleClass: String,
    spacing: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _HBox).() -> Unit)? = null
): HBox = _HBox(spacing, *children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [HBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledHbox(
    styleClass: String,
    spacing: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _HBox).() -> Unit)? = null
): HBox = javafxx.layouts.styledHbox(styleClass, spacing, *children, init = init)()