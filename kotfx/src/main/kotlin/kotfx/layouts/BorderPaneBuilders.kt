package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import javafx.scene.layout.BorderPane.*

@PublishedApi
internal class FXBorderPaneBuilder : BorderPaneBuilder {

    override val t: BorderPane = BorderPane()
}

interface BorderPaneBuilder : PaneBuilder<BorderPane> {

    infix fun Node.alignment(alignment: Pos) = setAlignment(this, alignment)
    val Node.alignment: Pos get() = getAlignment(this)

    infix fun Node.margin(insets: Insets) = setMargin(this, insets)
    fun Node.margin(top: Double, right: Double, bottom: Double, left: Double) = setMargin(this, Insets(top, right, bottom, left))
    val Node.margin: Insets get() = getMargin(this)

    infix fun Node.topMargin(margin: Double) = margin(8.0, 0.0, 0.0, 0.0)
    infix fun Node.rightMargin(margin: Double) = margin(0.0, 8.0, 0.0, 0.0)
    infix fun Node.bottomMargin(margin: Double) = margin(0.0, 0.0, 8.0, 0.0)
    infix fun Node.leftMargin(margin: Double) = margin(0.0, 0.0, 0.0, 8.0)

    fun Node.clearConstraints() = clearConstraints(this)
}