package kotfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Pos
import javafx.geometry.Pos.CENTER
import javafx.geometry.Pos.valueOf
import javafx.geometry.VPos
import javafx.scene.Node
import kotfx.internal.ChildManager

internal interface _Alignable : ChildManager {

    infix fun <T : Node> T.pos(pos: Pos): T
    infix fun <T : Node> T.hpos(hpos: HPos): T = pos(posOf(vpos, hpos))
    infix fun <T : Node> T.vpos(vpos: VPos): T = pos(posOf(vpos, hpos))

    val Node.pos: Pos
    val Node.hpos: HPos get() = pos.hpos
    val Node.vpos: VPos get() = pos.vpos

    fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
        if (it == "CENTER_CENTER") CENTER else valueOf(it)
    }
}