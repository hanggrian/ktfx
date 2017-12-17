package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER

class _HBox : HBox(), ChildManager, HGrowable, Marginable {
    override infix fun <N : Node> N.hpriority(value: Priority): N = apply { setHgrow(this, value) }
    override val Node.hpriority: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}