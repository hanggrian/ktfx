package ktfx.layouts

import javafx.geometry.HPos
import javafx.scene.Node

/**
 * Marks a layout manager with alignable children's horizontal position.
 *
 * @see KtfxGridPane
 */
interface HAlignConstraints : Constraints {

    var Node.halign: HPos?
}
