@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane
import ktfx.layouts.internal.AlignedPane
import ktfx.layouts.internal.MarginedPane

open class _TilePane(
    orientation: Orientation,
    hgap: Double,
    vgap: Double,
    vararg children: Node
) : TilePane(orientation, hgap, vgap, *children), LayoutManager<Node>, AlignedPane, MarginedPane {

    override val childs: ObservableList<Node> get() = children

    override fun Node.reset() = clearConstraints(this)

    override var Node.pos: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

inline fun tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node
): TilePane = tilePane(orientation, hgap, vgap, *children) { }

inline fun tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _TilePane).() -> Unit
): TilePane = _TilePane(orientation, hgap, vgap, *children).apply(init)

inline fun LayoutManager<Node>.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node
): TilePane = tilePane(orientation, hgap, vgap, *children) { }

inline fun LayoutManager<Node>.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    vararg children: Node,
    init: (@LayoutDsl _TilePane).() -> Unit
): TilePane = ktfx.layouts.tilePane(orientation, hgap, vgap, *children, init = init).add()