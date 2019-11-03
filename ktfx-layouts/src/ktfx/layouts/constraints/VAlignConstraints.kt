package ktfx.layouts

import javafx.geometry.VPos
import javafx.scene.Node

/**
 * Marks a layout manager with alignable children's vertical position.
 *
 * @see KtfxGridPane
 */
interface VAlignConstraints : Constraints {

    infix fun <N : Node> N.valign(vpos: VPos?): N =
        also { it.valign = vpos }

    var Node.valign: VPos?
}
