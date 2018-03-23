package ktfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Node
import javafx.scene.layout.BorderPane

@Suppress("ClassName")
open class _BorderPane : BorderPane(), ChildManager, AlignedPane, MarginedPane {

    override infix fun <N : Node> N.pos(value: Pos?): N = apply { setAlignment(this, value) }
    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.pos: Pos get() = getAlignment(this) ?: Pos.TOP_LEFT
    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun ChildManager.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = ktfx.layouts.borderPane(init).add()
inline fun ItemManager.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = ktfx.layouts.borderPane(init).add()
inline fun ButtonManager.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = ktfx.layouts.borderPane(init).add()