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

interface MarginableConstraints : Constraints {

    infix fun <N : Node> N.margins(margins: Insets?): N = also { it.margins = margins }

    infix fun <N : Node> N.marginAll(marginAll: Number?): N = also { it.marginAll = marginAll }

    infix fun <N : Node> N.marginTop(marginTop: Number?): N = also { it.marginTop = marginTop }

    infix fun <N : Node> N.marginRight(marginRight: Number?): N = also { it.marginRight = marginRight }

    infix fun <N : Node> N.marginBottom(marginBottom: Number?): N = also { it.marginBottom = marginBottom }

    infix fun <N : Node> N.marginLeft(marginLeft: Number?): N = also { it.marginLeft = marginLeft }

    var Node.margins: Insets? // alias for reserved variable `margin`

    var Node.marginAll: Number?
        @Deprecated(KtfxInternals.NO_GETTER, level = ERROR) get() = KtfxInternals.noGetter()
        set(value) {
            margins = value?.let { Insets(it.toDouble()) }
        }

    var Node.marginTop: Number?
        get() = margins?.top
        set(value) = updateMargin(top = value)

    var Node.marginRight: Number?
        get() = margins?.right
        set(value) = updateMargin(right = value)

    var Node.marginBottom: Number?
        get() = margins?.bottom
        set(value) = updateMargin(bottom = value)

    var Node.marginLeft: Number?
        get() = margins?.left
        set(value) = updateMargin(left = value)

    fun Node.updateMargin(
        top: Number? = marginTop,
        right: Number? = marginRight,
        bottom: Number? = marginBottom,
        left: Number? = marginLeft
    ) {
        margins = Insets(
            top?.toDouble() ?: 0.0, right?.toDouble() ?: 0.0,
            bottom?.toDouble() ?: 0.0, left?.toDouble() ?: 0.0
        )
    }
}

interface AlignableConstraints : Constraints {

    infix fun <N : Node> N.align(pos: Pos?): N = also { it.align = pos }

    var Node.align: Pos?
}

interface HAlignableConstraints : Constraints {

    infix fun <N : Node> N.halign(hpos: HPos?): N = also { it.halign = hpos }

    var Node.halign: HPos?
}

interface VAlignableConstraints : Constraints {

    infix fun <N : Node> N.valign(vpos: VPos?): N = also { it.valign = vpos }

    var Node.valign: VPos?
}

interface HGrowableConstraints : Constraints {

    infix fun <N : Node> N.hpriority(hpriority: Priority?): N = also { it.hpriority = hpriority }

    var Node.hpriority: Priority?
}

interface VGrowableConstraints : Constraints {

    infix fun <N : Node> N.vpriority(vpriority: Priority?): N = also { it.vpriority = vpriority }

    var Node.vpriority: Priority?
}

interface HBoxConstraints : NodeManager, HGrowableConstraints, MarginableConstraints {

    override fun Node.reset(): Unit = HBox.clearConstraints(this)

    override var Node.hpriority: Priority?
        get() = HBox.getHgrow(this)
        set(value) = HBox.setHgrow(this, value)

    override var Node.margins: Insets?
        get() = HBox.getMargin(this)
        set(value) = HBox.setMargin(this, value)
}
