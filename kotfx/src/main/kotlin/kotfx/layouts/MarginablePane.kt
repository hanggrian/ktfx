package kotfx

import javafx.geometry.Insets
import javafx.scene.Node

internal interface MarginablePane : ConstrainedPane {
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