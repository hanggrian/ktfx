package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_LEFT
import javafx.scene.Node
import javafx.scene.layout.StackPane

class _StackPane : StackPane(), ChildManager, Alignable, Marginable {
    override infix fun <N : Node> N.pos(value: Pos): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}