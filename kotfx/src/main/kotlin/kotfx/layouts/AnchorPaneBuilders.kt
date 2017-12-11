package kotfx.layouts

import javafx.scene.Node
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.AnchorPane.*

@PublishedApi
internal class FXAnchorPaneBuilder : FXPaneBuilder<AnchorPane>(), AnchorPaneBuilder {

    override val t: AnchorPane = AnchorPane()
}

interface AnchorPaneBuilder : PaneBuilder<AnchorPane> {

    infix fun Node.topAnchor(value: Double?) = setTopAnchor(this, value)
    val Node.topAnchor: Double get() = getTopAnchor(this) ?: 0.0

    infix fun Node.leftAnchor(value: Double?) = setLeftAnchor(this, value)
    val Node.leftAnchor: Double get() = getLeftAnchor(this) ?: 0.0

    infix fun Node.bottomAnchor(value: Double?) = setBottomAnchor(this, value)
    val Node.bottomAnchor: Double get() = getBottomAnchor(this) ?: 0.0

    infix fun Node.rightAnchor(value: Double?) = setRightAnchor(this, value)
    val Node.rightAnchor: Double get() = getRightAnchor(this) ?: 0.0

    fun Node.clearConstraints() = clearConstraints(this)
}