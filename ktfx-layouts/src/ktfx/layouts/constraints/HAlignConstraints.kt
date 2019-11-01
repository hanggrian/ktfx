@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.geometry.HPos
import javafx.scene.Node

/**
 * Marks a layout manager with alignable children's horizontal position.
 *
 * @see KtfxGridPane
 */
interface HAlignConstraints : Constraints {

    infix fun <N : Node> N.halign(hpos: HPos?): N =
        also { it.halign = hpos }

    var Node.halign: HPos?
}
