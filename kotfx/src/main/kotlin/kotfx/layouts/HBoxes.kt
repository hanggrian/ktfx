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
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _HBox : HBox(), HGrowable, Marginable {
    override val control: Pane get() = this

    override infix fun <T : Node> T.hgrow(priority: Priority): T = apply { setHgrow(this, priority) }
    override val Node.hgrow2: Priority get() = getHgrow(this) ?: NEVER

    override infix fun <T : Node> T.margin(insets: Insets): T = apply { setMargin(this, insets) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = _HBox().apply(init)
inline fun ChildManager.hbox(init: (@LayoutDsl _HBox).() -> Unit): HBox = _HBox().apply(init).add()