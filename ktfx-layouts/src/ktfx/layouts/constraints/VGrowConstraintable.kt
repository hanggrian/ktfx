package ktfx.layouts

import javafx.scene.layout.Priority

/**
 * Marks a layout manager with growable children's height.
 *
 * @see KtfxVBox
 * @see KtfxGridPane
 */
interface VGrowConstraintable : Constraintable {

    /** Children vertical grow priority in this layout. */
    var Constraints.vgrow: Priority?

    /** Configure vertical grow fluidly using infix operator. */
    infix fun Constraints.vgrow(priority: Priority): Constraints =
        apply { vgrow = priority }

    /** Configure vertical grow fluidly using infix operator. */
    infix fun Constraints.vgrow(always: Boolean): Constraints =
        vgrow(if (always) Priority.ALWAYS else Priority.NEVER)
}
