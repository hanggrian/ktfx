@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Pane
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import kotfx._Pane
import kotfx.internal.LayoutDsl

class _HBoxPane : HBox(), _HGrowablePane, _MarginablePane {
    override val node: Pane get() = this

    override infix fun <N : Node> N.hgrow(value: Priority): N = apply { setHgrow(this, value) }
    override val Node.hgrow2: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.margin(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.clearConstraints(): N = apply { clearConstraints(this) }
}

inline fun hboxOf(init: (@LayoutDsl _HBoxPane).() -> Unit): HBox = _HBoxPane().apply(init)
inline fun _Pane.hbox(init: (@LayoutDsl _HBoxPane).() -> Unit): HBox = hboxOf(init).add()