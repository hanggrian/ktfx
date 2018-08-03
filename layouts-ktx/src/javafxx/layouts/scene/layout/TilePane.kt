@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane
import javafxx.layouts.internal.AlignedPane
import javafxx.layouts.internal.MarginedPane

open class _TilePane(
    orientation: Orientation,
    hgap: Double,
    vgap: Double,
    vararg children: Node
) : TilePane(orientation, hgap, vgap, *children), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: MutableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Creates a [TilePane]. */
fun tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _TilePane).() -> Unit)? = null
): TilePane = _TilePane(orientation, hgap, vgap, *children).also {
    init?.invoke(it)
}

/** Creates a [TilePane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _TilePane).() -> Unit)? = null
): TilePane = javafxx.layouts.tilePane(orientation, hgap, vgap, *children, init = init)()

/** Create a styled [TilePane]. */
fun styledTilePane(
    styleClass: String,
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: ((@LayoutDsl _TilePane).() -> Unit)? = null
): TilePane = _TilePane(orientation, hgap, vgap, *children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TilePane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledTilePane(
    styleClass: String,
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    noinline init: ((@LayoutDsl _TilePane).() -> Unit)? = null
): TilePane = javafxx.layouts.styledTilePane(styleClass, orientation, hgap, vgap, *children, init = init)()