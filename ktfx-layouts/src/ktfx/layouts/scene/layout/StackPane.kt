package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.StackPane

@Suppress("ClassName")
open class _StackPane : StackPane(), ChildManager, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = ktfx.layouts.stackPane(init).add()
inline fun ItemManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = ktfx.layouts.stackPane(init).add()
inline fun ButtonManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = ktfx.layouts.stackPane(init).add()