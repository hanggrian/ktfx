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
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _VBox : VBox(), _VGrowable, _Marginable {

    override val instance: Pane get() = this

    override infix fun <T : Node> T.vgrow(priority: Priority): T = apply { setVgrow(this, priority) }
    override val Node.vgrow2: Priority get() = getVgrow(this) ?: NEVER

    override infix fun <T : Node> T.margin(insets: Insets): T = apply { setMargin(this, insets) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = _VBox().apply(init)
inline fun ChildManager.vbox(init: (@LayoutDsl _VBox).() -> Unit): VBox = _VBox().apply(init).add()