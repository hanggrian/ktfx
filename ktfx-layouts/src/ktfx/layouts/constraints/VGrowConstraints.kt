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

    /** Children vertical grow priority in this container. */
    var Node.vgrows: Priority?

    /** Convenient method to prioritize children vertical grow. */
    fun Node.vgrow() {
        vgrows = Priority.ALWAYS
    }

    /** Convenient method to never prioritize children vertical grow. */
    fun Node.vshrink() {
        vgrows = Priority.NEVER
    }
}
