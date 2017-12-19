package kotfx

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.FlowPane

class _FlowPane : FlowPane(), ChildManager, MarginablePane {
    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}