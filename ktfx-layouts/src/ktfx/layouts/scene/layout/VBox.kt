package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.Priority
import javafx.scene.layout.VBox

@Suppress("ClassName")
open class _VBox : VBox(), ChildManager, VGrowedPane, MarginedPane {

    override infix fun <N : Node> N.vpriority(value: Priority?): N = apply { setVgrow(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.vpriority: Priority get() = getVgrow(this) ?: Priority.NEVER
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = _VBox().apply(init)

inline fun Manager<Node>.vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = ktfx.layouts.vbox(init).add()