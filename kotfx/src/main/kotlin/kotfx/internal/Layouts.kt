package kotfx.internal

import javafx.collections.ObservableList
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority

interface Noded : Instanced<Pane> {

    /** Shadowed when being implemented in [javafx.scene.layout.Pane] */
    fun getChildren(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getChildren().add(this) }

    fun <T : Node> T.clearConstraints(): T

    fun padding(padding: Number) {
        instance.padding = Insets(padding.toDouble())
    }
}

internal interface Alignable : Noded {

    infix fun <T : Node> T.align(pos: Pos): T

    val Node.align: Pos
}

internal interface Marginable : Noded {

    infix fun <T : Node> T.margin(insets: Insets): T

    fun <T : Node> T.margin(top: Double, right: Double, bottom: Double, left: Double): T = margin(Insets(top, right, bottom, left))

    infix fun <T : Node> T.topMargin(margin: Double): T = margin(margin, rightMargin, bottomMargin, leftMargin)

    infix fun <T : Node> T.rightMargin(margin: Double): T = margin(topMargin, margin, bottomMargin, leftMargin)

    infix fun <T : Node> T.bottomMargin(margin: Double): T = margin(topMargin, rightMargin, margin, leftMargin)

    infix fun <T : Node> T.leftMargin(margin: Double): T = margin(topMargin, rightMargin, bottomMargin, margin)

    val Node.margin2: Insets

    val Node.topMargin: Double get() = margin2.top

    val Node.rightMargin: Double get() = margin2.right

    val Node.bottomMargin: Double get() = margin2.bottom

    val Node.leftMargin: Double get() = margin2.left
}

internal interface HGrowable : Noded {

    infix fun <T : Node> T.hgrow(priority: Priority): T

    val Node.hgrow2: Priority
}

internal interface VGrowable : Noded {

    infix fun <T : Node> T.vgrow(priority: Priority): T

    val Node.vgrow2: Priority
}