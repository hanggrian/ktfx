@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import javafx.scene.layout.VBox
import kotfx._Pane
import kotfx.internal.LayoutDsl

class _VBoxPane : VBox(), _VGrowablePane, _MarginablePane {
    override val node: Pane get() = this

    override infix fun <N : Node> N.vgrow(value: Priority): N = apply { setVgrow(this, value) }
    override val Node.vgrow2: Priority get() = getVgrow(this) ?: NEVER

    override infix fun <N : Node> N.margin(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.clearConstraints(): N = apply { clearConstraints(this) }
}

inline fun vboxOf(init: (@LayoutDsl _VBoxPane).() -> Unit): VBox = _VBoxPane().apply(init)
inline fun _Pane.vbox(init: (@LayoutDsl _VBoxPane).() -> Unit): VBox = vboxOf(init).add()