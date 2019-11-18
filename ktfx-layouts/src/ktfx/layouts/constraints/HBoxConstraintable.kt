package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority

/** [javafx.scene.layout.HBox] constraints. */
interface HBoxConstraintable : NodeManager, HGrowConstraintable, MarginConstraintable {

    override fun Constraints.clear(): Unit =
        HBox.clearConstraints(node)

    override var Constraints.hgrow: Priority?
        get() = HBox.getHgrow(node)
        set(value) = HBox.setHgrow(node, value)

    override var Constraints.margin: Insets?
        get() = HBox.getMargin(node)
        set(value) = HBox.setMargin(node, value)
}
