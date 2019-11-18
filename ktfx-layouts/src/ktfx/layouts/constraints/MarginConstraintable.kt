package ktfx.layouts

import javafx.geometry.Insets
import ktfx.internal.KtfxInternals

/**
 * Marks a layout manager with modifiable children's margin.
 *
 * @see KtfxBorderPane
 * @see KtfxFlowPane
 * @see KtfxGridPane
 * @see KtfxStackPane
 * @see KtfxTilePane
 * @see KtfxHBox
 * @see KtfxVBox
 */
interface MarginConstraintable : Constraintable {

    /** Children margin in this layout. */
    var Constraints.margin: Insets?

    /** Children all sides margin in this layout. */
    var Constraints.marginAll: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            margin = value?.let { Insets(it) }
        }

    /** Children top margin in this layout. */
    var Constraints.marginTop: Double?
        get() = margin?.top
        set(value) = updateMargin(top = value)

    /** Children right margin in this layout. */
    var Constraints.marginRight: Double?
        get() = margin?.right
        set(value) = updateMargin(right = value)

    /** Children bottom margin in this layout. */
    var Constraints.marginBottom: Double?
        get() = margin?.bottom
        set(value) = updateMargin(bottom = value)

    /** Children left margin in this layout. */
    var Constraints.marginLeft: Double?
        get() = margin?.left
        set(value) = updateMargin(left = value)

    fun Constraints.updateMargin(
        top: Double? = marginTop,
        right: Double? = marginRight,
        bottom: Double? = marginBottom,
        left: Double? = marginLeft
    ) {
        margin = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
    }

    /** Configure margin fluidly using infix operator. */
    infix fun Constraints.margin(margin: Insets): Constraints =
        apply { this.margin = margin }

    /** Configure all sides margin fluidly using infix operator. */
    infix fun Constraints.marginAll(margin: Double?): Constraints =
        apply { marginAll = margin }

    /** Configure top margin fluidly using infix operator. */
    infix fun Constraints.marginTop(margin: Double?): Constraints =
        apply { marginTop = margin }

    /** Configure right margin fluidly using infix operator. */
    infix fun Constraints.marginRight(margin: Double?): Constraints =
        apply { marginRight = margin }

    /** Configure bottom margin fluidly using infix operator. */
    infix fun Constraints.marginBottom(margin: Double?): Constraints =
        apply { marginBottom = margin }

    /** Configure left margin fluidly using infix operator. */
    infix fun Constraints.marginLeft(margin: Double?): Constraints =
        apply { marginLeft = margin }
}
