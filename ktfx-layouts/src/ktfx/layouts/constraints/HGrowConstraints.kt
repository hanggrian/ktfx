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

    /** Children horizontal grow priority in this container. */
    var Node.hgrows: Priority?

    /** Convenient method to prioritize children horizontal grow. */
    fun Node.hgrow() {
        hgrows = Priority.ALWAYS
    }

    /** Convenient method to never prioritize children horizontal grow. */
    fun Node.hshrink() {
        hgrows = Priority.NEVER
    }
}
