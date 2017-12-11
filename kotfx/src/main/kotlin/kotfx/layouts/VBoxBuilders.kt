package kotfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox
import javafx.scene.layout.VBox.*

@PublishedApi
internal class FXVBoxBuilder : FXPaneBuilder<VBox>(), VBoxBuilder {

    override val t: VBox = VBox()
}

interface VBoxBuilder : PaneBuilder<VBox> {

    infix fun Node.vgrow(priority: Priority) = setVgrow(this, priority)
    val Node.vgrow: Priority get() = getVgrow(this)

    fun Node.margin(top: Double, right: Double, bottom: Double, left: Double) = setMargin(this, Insets(top, right, bottom, left))
    infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    val Node.margin: Insets get() = getMargin(this)

    fun Node.clearConstraints() = VBox.clearConstraints(this)
}