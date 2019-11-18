package ktfx.layouts

import javafx.geometry.Pos

/**
 * Marks a layout manager with alignable children's position.
 *
 * @see KtfxBorderPane
 * @see KtfxStackPane
 * @see KtfxTilePane
 */
interface AlignmentConstraintable : Constraintable {

    /** Children alignment in this layout. */
    var Constraints.alignment: Pos?

    /** Configure alignment fluidly using infix operator. */
    infix fun Constraints.align(pos: Pos): Constraints =
        apply { alignment = pos }
}
