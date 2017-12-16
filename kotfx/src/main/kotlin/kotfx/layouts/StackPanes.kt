@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.geometry.Pos
import javafx.geometry.Pos.TOP_LEFT
import javafx.scene.Node
import javafx.scene.layout.StackPane
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.LayoutDsl

class _StackPane : StackPane(), ChildManager, Alignable, Marginable {
    override infix fun <N : Node> N.pos(value: Pos): N = apply { setAlignment(this, value) }
    override val Node.pos: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <N : Node> N.margin(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.clearConstraints(): N = apply { clearConstraints(this) }
}

inline fun stackPaneOf(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init)
inline fun ChildManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()
inline fun ItemManager.stackPane(init: (@LayoutDsl _StackPane).() -> Unit): StackPane = _StackPane().apply(init).add()