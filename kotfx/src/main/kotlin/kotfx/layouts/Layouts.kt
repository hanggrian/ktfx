@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.Node
import javafx.scene.layout.Priority
import kotfx.internal.ChildManager

internal interface Alignable : ChildManager {
    infix fun <T : Node> T.pos(pos: Pos): T
    infix fun <T : Node> T.hpos(hpos: HPos): T = pos(posOf(vpos, hpos))
    infix fun <T : Node> T.vpos(vpos: VPos): T = pos(posOf(vpos, hpos))

    val Node.pos: Pos
    val Node.hpos: HPos get() = pos.hpos
    val Node.vpos: VPos get() = pos.vpos

    fun posOf(vpos: VPos, hpos: HPos): Pos = "${vpos}_$hpos".let {
        if (it == "CENTER_CENTER") Pos.CENTER else Pos.valueOf(it)
    }
}

internal interface Marginable : ChildManager {
    infix fun <T : Node> T.margin(insets: Insets): T
    fun <T : Node> T.margin(top: Number, right: Number, bottom: Number, left: Number): T = margin(Insets(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble()))
    infix fun <T : Node> T.marginTop(margin: Number): T = margin(margin, marginRight, marginBottom, marginLeft)
    infix fun <T : Node> T.marginRight(margin: Number): T = margin(marginTop, margin, marginBottom, marginLeft)
    infix fun <T : Node> T.marginBottom(margin: Number): T = margin(marginTop, marginRight, margin, marginLeft)
    infix fun <T : Node> T.marginLeft(margin: Number): T = margin(marginTop, marginRight, marginBottom, margin)

    val Node.margin2: Insets
    val Node.marginTop: Double get() = margin2.top
    val Node.marginRight: Double get() = margin2.right
    val Node.marginBottom: Double get() = margin2.bottom
    val Node.marginLeft: Double get() = margin2.left
}

internal interface HGrowable : ChildManager {
    infix fun <T : Node> T.hgrow(priority: Priority): T
    val Node.hgrow2: Priority
}

internal interface VGrowable : ChildManager {
    infix fun <T : Node> T.vgrow(priority: Priority): T
    val Node.vgrow2: Priority
}