@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane

open class _TilePane(orientation: Orientation, hgap: Double, vgap: Double) : TilePane(orientation, hgap, vgap),
    NodeManager, AlignConstraints, MarginConstraints {

    override fun <T : Node> addNode(node: T): T = node.also { children += it }

    override fun Node.reset(): Unit = clearConstraints(this)

    override var Node.align: Pos?
        get() = getAlignment(this)
        set(value) = setAlignment(this, value)

    override var Node.margins: Insets?
        get() = getMargin(this)
        set(value) = setMargin(this, value)
}

/** Create a [TilePane] with initialization block. */
inline fun tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    init: (@LayoutDslMarker _TilePane).() -> Unit
): TilePane = _TilePane(orientation, hgap, vgap).apply(init)

/** Add a [TilePane] to this manager. */
fun NodeManager.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0
): TilePane = addNode(ktfx.layouts.tilePane(orientation, hgap, vgap) { })

/** Add a [TilePane] with initialization block to this manager. */
inline fun NodeManager.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    init: (@LayoutDslMarker _TilePane).() -> Unit
): TilePane = addNode(ktfx.layouts.tilePane(orientation, hgap, vgap, init))
