package ktfx.layouts

import javafx.geometry.Pos
import javafx.scene.Node

/**
 * Marks a layout manager with alignable children's position.
 *
 * @see KtfxBorderPane
 * @see KtfxStackPane
 * @see KtfxTilePane
 */
interface AlignConstraints : Constraints {

    infix fun <N : Node> N.align(pos: Pos?): N =
        also { it.align = pos }

    var Node.align: Pos?
}
