@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

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

    infix fun <N : Node> N.margins(margins: Insets?): N =
        also { it.margins = margins }

    infix fun <N : Node> N.marginAll(marginAll: Double?): N =
        also { it.marginAll = marginAll }

    infix fun <N : Node> N.marginTop(marginTop: Double?): N =
        also { it.marginTop = marginTop }

    infix fun <N : Node> N.marginRight(marginRight: Double?): N =
        also { it.marginRight = marginRight }

    infix fun <N : Node> N.marginBottom(marginBottom: Double?): N =
        also { it.marginBottom = marginBottom }

    infix fun <N : Node> N.marginLeft(marginLeft: Double?): N =
        also { it.marginLeft = marginLeft }

    /** Alias for reserved variable `margin`. */
    var Node.margins: Insets?

    var Node.marginAll: Double?
        @Deprecated(KtfxInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            margins = when (value) {
                null -> null
                else -> Insets(value)
            }
        }

    var Node.marginTop: Double?
        get() = margins?.top
        set(value) = updateMargin(top = value)

    var Node.marginRight: Double?
        get() = margins?.right
        set(value) = updateMargin(right = value)

    var Node.marginBottom: Double?
        get() = margins?.bottom
        set(value) = updateMargin(bottom = value)

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
