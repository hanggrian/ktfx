@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.HBox
import javafx.scene.layout.Priority
import javafx.scene.layout.Priority.NEVER
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.LayoutDsl

class _HBox : HBox(), ChildManager, HGrowable, Marginable {
    override infix fun <N : Node> N.hGrow(value: Priority): N = apply { setHgrow(this, value) }
    override val Node.hGrow: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <N : Node> N.margins(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margins: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.reset(): N = apply { clearConstraints(this) }
}

inline fun hboxOf(init: (@LayoutDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildManager.hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()
inline fun ItemManager.hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()