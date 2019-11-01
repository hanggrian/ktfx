@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority

/**
 * Marks a layout manager with growable children's width.
 * It uses `hpriority` name since `hgrow` would clash with [javafx.scene.layout.GridPane.setHgrow]
 * and [javafx.scene.layout.GridPane.getHgrow].
 *
 * @see KtfxHBox
 * @see KtfxGridPane
 */
interface HGrowConstraints : Constraints {

    infix fun <N : Node> N.hpriority(hpriority: Priority?): N =
        also { it.hpriority = hpriority }

    var Node.hpriority: Priority?
}
