package kotfx

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import javafx.scene.layout.VBox

class _VBox : VBox(), ChildManager, VGrowablePane, MarginablePane {
    override infix fun <N : Node> N.vpriority(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vpriority: Priority get() = getVgrow(this) ?: NEVER

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}