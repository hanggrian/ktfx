package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority

@Suppress("ClassName")
open class _HBox : HBox(), ChildManager, HGrowedPane, MarginedPane {

    override infix fun <N : Node> N.hpriority(value: Priority?): N = apply { setHgrow(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.hpriority: Priority get() = getHgrow(this) ?: Priority.NEVER
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = _HBox().apply(init)

inline fun Manager<Node>.hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = ktfx.layouts.hbox(init).add()