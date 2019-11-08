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

    var Node.align: Pos?
}
