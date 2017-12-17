package kotfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node

internal interface Alignable : Constrained {
    infix fun <N : Node> N.pos(value: Pos): N
    infix fun <N : Node> N.hPos(value: HPos): N = pos(posOf(vPos, value))
    infix fun <N : Node> N.vPos(value: VPos): N = pos(posOf(value, hPos))

    val Node.pos: Pos
    val Node.hPos: HPos get() = pos.hpos
    val Node.vPos: VPos get() = pos.vpos

    fun posOf(v: VPos, h: HPos): Pos = "${v}_$h".let { if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it) }
}