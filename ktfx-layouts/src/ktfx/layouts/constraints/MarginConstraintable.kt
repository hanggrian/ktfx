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

    /** Children margin in this container, alias for reserved property `margin`. */
    var Constraints.margin: Insets?

    /** Conveniently set margin to all sides. */
    var Constraints.marginAll: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            margin = when (value) {
                null -> null
                else -> Insets(value)
            }
        }

    infix fun Constraints.marginAll(margin: Double?): Constraints =
        apply { marginAll = margin }

    /** Conveniently set top margin. */
    var Constraints.marginTop: Double?
        get() = margin?.top
        set(value) = updateMargin(top = value)

    /** Conveniently set right margin. */
    var Constraints.marginRight: Double?
        get() = margin?.right
        set(value) = updateMargin(right = value)

    /** Conveniently set bottom margin. */
    var Constraints.marginBottom: Double?
        get() = margin?.bottom
        set(value) = updateMargin(bottom = value)

    /** Conveniently set left margin. */
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
}
