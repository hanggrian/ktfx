@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Orientation
import javafx.geometry.Orientation.HORIZONTAL
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.TilePane

open class _TilePane(orientation: Orientation, hgap: Double, vgap: Double) : TilePane(orientation, hgap, vgap),
    NodeManager, AlignableConstraints, MarginableConstraints {

    override fun <R : Node> R.add(): R = also { children += it }

    override fun Node.reset(): Unit = clearConstraints(this)

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
    init: ((@LayoutDslMarker _TilePane).() -> Unit)? = null
): TilePane = _TilePane(orientation, hgap, vgap).also { init?.invoke(it) }

/** Creates a [TilePane] and add it to this manager. */
inline fun NodeManager.tilePane(
    orientation: Orientation = HORIZONTAL,
    hgap: Double = 0.0,
    vgap: Double = 0.0,
    noinline init: ((@LayoutDslMarker _TilePane).() -> Unit)? = null
): TilePane = ktfx.layouts.tilePane(orientation, hgap, vgap, init).add()
