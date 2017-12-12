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
import kotfx.internal.Alignable
import kotfx.internal.LayoutDsl
import kotfx.internal.Marginable
import kotfx.internal.Noded

class _BorderPane : BorderPane(), Alignable, Marginable {

    override val instance: Pane get() = this

    override infix fun <T : Node> T.align(pos: Pos): T = apply { setAlignment(this, pos) }
    override val Node.align: Pos get() = getAlignment(this) ?: TOP_LEFT

    override infix fun <T : Node> T.margin(insets: Insets): T = apply { setMargin(this, insets) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init)
inline fun Noded.borderPane(init: (@LayoutDsl _BorderPane).() -> Unit): BorderPane = _BorderPane().apply(init).add()