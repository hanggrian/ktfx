package ktfx.layouts

import javafx.geometry.VPos
import javafx.scene.Node

/**
 * Marks a layout manager with alignable children's vertical position.
 *
 * @see KtfxGridPane
 */
interface VAlignConstraints : Constraints {

    var Node.valign: VPos?
}
