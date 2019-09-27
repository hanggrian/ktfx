@file:Suppress("SpellCheckingInspection")

package ktfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import kotlin.DeprecationLevel.ERROR
import ktfx.internal.KtfxInternals

interface Constraints {

    fun Node.reset()
}

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
        @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
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

/**
 * Marks a layout manager with alignable children's position.
 *
 * @see KtfxBorderPane
 * @see KtfxStackPane
 * @see KtfxTilePane
 */
interface AlignConstraints : Constraints {

    infix fun <N : Node> N.align(pos: Pos?): N =
        also { it.align = pos }

    var Node.align: Pos?
}

/**
 * Marks a layout manager with alignable children's horizontal position.
 *
 * @see KtfxGridPane
 */
interface HAlignConstraints : Constraints {

    infix fun <N : Node> N.halign(hpos: HPos?): N =
        also { it.halign = hpos }

    var Node.halign: HPos?
}

/**
 * Marks a layout manager with alignable children's vertical position.
 *
 * @see KtfxGridPane
 */
interface VAlignConstraints : Constraints {

    infix fun <N : Node> N.valign(vpos: VPos?): N =
        also { it.valign = vpos }

    var Node.valign: VPos?
}

/**
 * Marks a layout manager with growable children's width.
 * It uses `hpriority` name since `hgrow` would clash with [javafx.scene.layout.GridPane.setHgrow]
 * and [javafx.scene.layout.GridPane.getHgrow].
 *
 * @see KtfxHBox
 * @see KtfxGridPane
 */
interface HGrowConstraints : Constraints {

    infix fun <N : Node> N.hpriority(hpriority: Priority?): N =
        also { it.hpriority = hpriority }

    var Node.hpriority: Priority?
}

/**
 * Marks a layout manager with growable children's height.
 * It uses `vpriority` name since `vgrow` would clash with [javafx.scene.layout.GridPane.setHgrow]
 * and [javafx.scene.layout.GridPane.getHgrow].
 *
 * @see KtfxVBox
 * @see KtfxGridPane
 */
interface VGrowConstraints : Constraints {

    infix fun <N : Node> N.vpriority(vpriority: Priority?): N =
        also { it.vpriority = vpriority }

    var Node.vpriority: Priority?
}

/** [javafx.scene.layout.HBox] constraints. */
interface HBoxConstraints : NodeManager, HGrowConstraints, MarginConstraints {

    override fun Node.reset(): Unit =
        HBox.clearConstraints(this)

    override var Node.hpriority: Priority?
        get() = HBox.getHgrow(this)
        set(value) = HBox.setHgrow(this, value)

    override var Node.margins: Insets?
        get() = HBox.getMargin(this)
        set(value) = HBox.setMargin(this, value)
}
