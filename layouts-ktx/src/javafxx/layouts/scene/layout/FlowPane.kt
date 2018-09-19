@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.scene.Node
import javafx.scene.layout.FlowPane

open class _FlowPane(
    orientation: Orientation,
    hgap: Double,
    vgap: Double,
    vararg children: Node
) : FlowPane(orientation, hgap, vgap, *children), LayoutManager<Node>, MarginedPane {

    override val childs: MutableCollection<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [FlowPane]. */
fun flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = _FlowPane(orientation, hgap, vgap, *children).also {
    init?.invoke(it)
}

/** Creates a [FlowPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.flowPane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = javafxx.layouts.flowPane(orientation, hgap, vgap, *children, init = init)()

/** Create a styled [FlowPane]. */
fun styledFlowPane(
    styleClass: String,
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = _FlowPane(orientation, hgap, vgap, *children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [FlowPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledFlowPane(
    styleClass: String,
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = javafxx.layouts.styledFlowPane(styleClass, orientation, hgap, vgap, *children, init = init)()