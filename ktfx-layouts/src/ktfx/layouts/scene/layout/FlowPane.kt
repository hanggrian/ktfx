package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.FlowPane

@Suppress("ClassName")
open class _FlowPane : FlowPane(), ChildManager, MarginedPane {

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)

inline fun Manager<Node>.flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = ktfx.layouts.flowPane(init).add()