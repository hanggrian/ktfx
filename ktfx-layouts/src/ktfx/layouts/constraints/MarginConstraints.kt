package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
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
interface MarginConstraints : Constraints {

    /** Children margin in this container, alias for reserved property `margin`. */
    var Node.margins: Insets?

    /** Conveniently set margin to all sides. */
    var Node.marginAll: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            margins = when (value) {
                null -> null
                else -> Insets(value)
            }
        }

    /** Conveniently set top margin. */
    var Node.marginTop: Double?
        get() = margins?.top
        set(value) = updateMargin(top = value)

    /** Conveniently set right margin. */
    var Node.marginRight: Double?
        get() = margins?.right
        set(value) = updateMargin(right = value)

    /** Conveniently set bottom margin. */
    var Node.marginBottom: Double?
        get() = margins?.bottom
        set(value) = updateMargin(bottom = value)

    /** Conveniently set left margin. */
    var Node.marginLeft: Double?
        get() = margins?.left
        set(value) = updateMargin(left = value)

    fun Node.updateMargin(
        top: Double? = marginTop,
        right: Double? = marginRight,
        bottom: Double? = marginBottom,
        left: Double? = marginLeft
    ) {
        margins = Insets(top ?: 0.0, right ?: 0.0, bottom ?: 0.0, left ?: 0.0)
    }
}
