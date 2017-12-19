package kotfx

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos
import javafx.scene.Node

internal interface AlignablePane : ConstrainedPane {
    infix fun <N : Node> N.pos(value: Pos): N
    infix fun <N : Node> N.hpos(value: HPos): N = pos(posOf(vpos, value))
    infix fun <N : Node> N.vpos(value: VPos): N = pos(posOf(value, hpos))

    val Node.pos: Pos
    val Node.hpos: HPos get() = pos.hpos
    val Node.vpos: VPos get() = pos.vpos

    fun posOf(v: VPos, h: HPos): Pos = "${v}_$h".let { if (it == "CENTER_CENTER") CENTER else valueOf(it) }
}