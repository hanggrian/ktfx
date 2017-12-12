package kotfx.layouts

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.Priority

interface Noded {

    /** Shadowed when being implemented in [javafx.scene.layout.Pane] */
    fun getChildren(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getChildren().add(this) }

    fun Node.removeConstraints()
}

internal interface Alignable : Noded {

    infix fun Node.align(pos: Pos)

    val Node.align: Pos
}

internal interface Marginable : Noded {

    infix fun Node.margin(insets: Insets)

    fun Node.margin(top: Double, right: Double, bottom: Double, left: Double) = margin(Insets(top, right, bottom, left))

    infix fun Node.topMargin(margin: Double) = margin(margin, rightMargin, bottomMargin, leftMargin)

    infix fun Node.rightMargin(margin: Double) = margin(topMargin, margin, bottomMargin, leftMargin)

    infix fun Node.bottomMargin(margin: Double) = margin(topMargin, rightMargin, margin, leftMargin)

    infix fun Node.leftMargin(margin: Double) = margin(topMargin, rightMargin, bottomMargin, margin)

    val Node.margin2: Insets

    val Node.topMargin: Double get() = margin2.top

    val Node.rightMargin: Double get() = margin2.right

    val Node.bottomMargin: Double get() = margin2.bottom

    val Node.leftMargin: Double get() = margin2.left
}

internal interface HGrowable : Noded {

    infix fun Node.hgrow(priority: Priority)

    val Node.hgrow2: Priority
}

internal interface VGrowable : Noded {

    infix fun Node.vgrow(priority: Priority)

    val Node.vgrow2: Priority
}