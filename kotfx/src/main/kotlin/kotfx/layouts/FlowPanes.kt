@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.FlowPane
import javafx.scene.layout.Pane
import kotfx.internal.ChildManager
import kotfx.internal.LayoutDsl

class _FlowPane : FlowPane(), _Marginable {

    override val instance: Pane get() = this

    override infix fun <T : Node> T.margin(insets: Insets): T = apply { setMargin(this, insets) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <T : Node> T.clearConstraints(): T = apply { clearConstraints(this) }
}

inline fun flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildManager.flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()