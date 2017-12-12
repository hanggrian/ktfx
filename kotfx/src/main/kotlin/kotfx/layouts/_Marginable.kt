package kotfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import kotfx.internal.ChildManager

internal interface _Marginable : ChildManager {

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