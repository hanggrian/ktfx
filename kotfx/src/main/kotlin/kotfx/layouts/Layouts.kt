@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.Priority

internal interface Alignable : Constrained {
    infix fun <N : Node> N.pos(value: Pos): N
    infix fun <N : Node> N.hPos(value: HPos): N = pos(posOf(vPos, value))
    infix fun <N : Node> N.vPos(value: VPos): N = pos(posOf(value, hPos))

    val Node.pos: Pos
    val Node.hPos: HPos get() = pos.hpos
    val Node.vPos: VPos get() = pos.vpos

    fun posOf(v: VPos, h: HPos): Pos = "${v}_$h".let { if (it == "CENTER_CENTER") CENTER else valueOf(it) }
}

internal interface Marginable : Constrained {
    infix fun <N : Node> N.margins(value: Insets): N
    fun <N : Node> N.margins(top: Number, right: Number, bottom: Number, left: Number): N = margins(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))
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

internal interface HGrowable : Constrained {
    infix fun <N : Node> N.hGrow(value: Priority): N
    val Node.hGrow: Priority
}

internal interface VGrowable : Constrained {
    infix fun <N : Node> N.vGrow(value: Priority): N
    val Node.vGrow: Priority
}

internal interface Constrained {
    fun <N : Node> N.reset(): N
}