@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_LEFT
import javafx.scene.Node
import javafx.scene.layout.TilePane

class _TilePane : TilePane(), Alignable, Marginable {

    override infix fun Node.align(pos: Pos) = setAlignment(this, pos)
    override val Node.align: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun Node.removeConstraints() = clearConstraints(this)
}