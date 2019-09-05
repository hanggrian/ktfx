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

    fun Node.reset() // ktlint-disable
}

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

    var Node.margins: Insets? // alias for reserved variable `margin`

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
        margins = Insets(
            top ?: 0.0,
            right ?: 0.0,
            bottom ?: 0.0,
            left ?: 0.0
        )
    }
}

interface AlignConstraints : Constraints {

    infix fun <N : Node> N.align(pos: Pos?): N =
        also { it.align = pos }

    var Node.align: Pos?
}

interface HAlignConstraints : Constraints {

    infix fun <N : Node> N.halign(hpos: HPos?): N =
        also { it.halign = hpos }

    var Node.halign: HPos?
}

interface VAlignConstraints : Constraints {

    infix fun <N : Node> N.valign(vpos: VPos?): N =
        also { it.valign = vpos }

    var Node.valign: VPos?
}

interface HGrowConstraints : Constraints {

    infix fun <N : Node> N.hpriority(hpriority: Priority?): N =
        also { it.hpriority = hpriority }

    var Node.hpriority: Priority?
}

interface VGrowConstraints : Constraints {

    infix fun <N : Node> N.vpriority(vpriority: Priority?): N =
        also { it.vpriority = vpriority }

    var Node.vpriority: Priority?
}

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