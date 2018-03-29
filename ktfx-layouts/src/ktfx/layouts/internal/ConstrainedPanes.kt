package ktfx.layouts.internal

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.Priority
import ktfx.geometry.plus

internal interface ConstrainedPane {

    fun Node.reset()
}

internal interface MarginedPane : ConstrainedPane {

    infix fun <N : Node> N.margins(value: Insets?): N

    infix fun <N : Node> N.margins(value: Number) = margins(Insets(value.toDouble()))

    fun <N : Node> N.margins(top: Number, right: Number, bottom: Number, left: Number): N =
        margins(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

    infix fun <N : Node> N.marginTop(value: Number): N = margins(value, marginRight, marginBottom, marginLeft)

    infix fun <N : Node> N.marginRight(value: Number): N = margins(marginTop, value, marginBottom, marginLeft)

    infix fun <N : Node> N.marginBottom(value: Number): N = margins(marginTop, marginRight, value, marginLeft)

    infix fun <N : Node> N.marginLeft(value: Number): N = margins(marginTop, marginRight, marginBottom, value)

    val Node.margins: Insets

    val Node.marginTop: Double get() = margins.top

    val Node.marginRight: Double get() = margins.right

    val Node.marginBottom: Double get() = margins.bottom

    val Node.marginLeft: Double get() = margins.left
}

internal interface AlignedPane : ConstrainedPane {

    infix fun <N : Node> N.pos(value: Pos?): N

    infix fun <N : Node> N.hpos(value: HPos?): N = pos(vpos + (value ?: hpos))

    infix fun <N : Node> N.vpos(value: VPos?): N = pos((value ?: vpos) + hpos)

    val Node.pos: Pos

    val Node.hpos: HPos get() = pos.hpos

    val Node.vpos: VPos get() = pos.vpos
}

internal interface HGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.hpriority(value: Priority?): N

    val Node.hpriority: Priority
}

internal interface VGrowedPane : ConstrainedPane {

    infix fun <N : Node> N.vpriority(value: Priority?): N

    val Node.vpriority: Priority
}