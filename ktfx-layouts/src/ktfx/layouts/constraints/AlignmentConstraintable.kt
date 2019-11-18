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

    /** Children alignment in this container. */
    var Constraints.alignment: Pos?

    infix fun Constraints.align(pos: Pos): Constraints =
        apply { alignment = pos }
}
