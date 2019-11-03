package ktfx.layouts

import javafx.scene.Node
import javafx.scene.layout.Priority

/**
 * Marks a layout manager with growable children's height.
 * It uses `vpriority` name since `vgrow` would clash with [javafx.scene.layout.GridPane.setHgrow]
 * and [javafx.scene.layout.GridPane.getHgrow].
 *
 * @see KtfxVBox
 * @see KtfxGridPane
 */
interface VGrowConstraints : Constraints {

    infix fun <N : Node> N.vpriority(vpriority: Priority?): N =
        also { it.vpriority = vpriority }

    var Node.vpriority: Priority?
}
