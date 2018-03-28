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

    infix fun <N : Node> N.margins(value: Int) = margins(Insets(value.toDouble()))

    fun <N : Node> N.margins(top: Int, right: Int, bottom: Int, left: Int): N =
        margins(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))

    infix fun <N : Node> N.marginTop(value: Int): N = margins(value, marginRight, marginBottom, marginLeft)

    infix fun <N : Node> N.marginRight(value: Int): N = margins(marginTop, value, marginBottom, marginLeft)

    infix fun <N : Node> N.marginBottom(value: Int): N = margins(marginTop, marginRight, value, marginLeft)

    infix fun <N : Node> N.marginLeft(value: Int): N = margins(marginTop, marginRight, marginBottom, value)

    val Node.margins: Insets

    val Node.marginTop: Int get() = margins.top.toInt()

    val Node.marginRight: Int get() = margins.right.toInt()

    val Node.marginBottom: Int get() = margins.bottom.toInt()

    val Node.marginLeft: Int get() = margins.left.toInt()
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