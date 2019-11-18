package ktfx.layouts

import javafx.scene.layout.Priority

/**
 * Marks a layout manager with growable children's width.
 * It uses `hpriority` name since `hgrow` would clash with [javafx.scene.layout.GridPane.setHgrow]
 * and [javafx.scene.layout.GridPane.getHgrow].
 *
 * @see KtfxHBox
 * @see KtfxGridPane
 */
interface HGrowConstraintable : Constraintable {

    /** Children horizontal grow priority in this container. */
    var Constraints.hgrow: Priority?

    infix fun Constraints.hgrow(priority: Priority): Constraints =
        apply { hgrow = priority }

    infix fun Constraints.hgrow(always: Boolean): Constraints =
        hgrow(Priority.ALWAYS)
}
