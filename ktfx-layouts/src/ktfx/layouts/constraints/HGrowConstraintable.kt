package ktfx.layouts

import javafx.scene.layout.Priority

/**
 * Marks a layout manager with growable children's width.
 *
 * @see KtfxHBox
 * @see KtfxGridPane
 */
interface HGrowConstraintable : Constraintable {

    /** Children horizontal grow priority in this layout. */
    var Constraints.hgrow: Priority?

    /** Configure horizontal grow fluidly using infix operator. */
    infix fun Constraints.hgrow(priority: Priority): Constraints =
        apply { hgrow = priority }

    /** Configure horizontal grow fluidly using infix operator. */
    infix fun Constraints.hgrow(always: Boolean): Constraints =
        hgrow(if (always) Priority.ALWAYS else Priority.NEVER)
}
