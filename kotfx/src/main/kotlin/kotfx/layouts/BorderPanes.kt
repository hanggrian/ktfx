@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_LEFT
import javafx.scene.Node
import javafx.scene.layout.BorderPane
import javafx.scene.layout.Pane
import kotfx._Pane
import kotfx.internal.LayoutDsl

class _BorderPane : BorderPane(), _AlignablePane, _MarginablePane {
    override val node: Pane get() = this

    override infix fun <N : Node> N.pos(value: Pos): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margin(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.clearConstraints(): N = apply { clearConstraints(this) }
}

inline fun borderPaneOf(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun _Pane.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = borderPaneOf(init).add()