package ktfx.layouts

import javafx.scene.layout.Priority

/**
 * Marks a layout manager with growable children's height.
 * It uses `vpriority` name since `vgrow` would clash with [javafx.scene.layout.GridPane.setHgrow]
 * and [javafx.scene.layout.GridPane.getHgrow].
 *
 * @see KtfxVBox
 * @see KtfxGridPane
 */
interface VGrowConstraintable : Constraintable {

    /** Children vertical grow priority in this container. */
    var Constraints.vgrow: Priority?

    infix fun Constraints.vgrow(priority: Priority): Constraints =
        apply { vgrow = priority }

    infix fun Constraints.vgrow(always: Boolean): Constraints =
        vgrow(Priority.ALWAYS)
}
