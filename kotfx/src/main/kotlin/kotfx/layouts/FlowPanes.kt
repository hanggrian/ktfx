@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx.layouts

import javafx.geometry.Insets
import javafx.geometry.Insets.EMPTY
import javafx.scene.Node
import javafx.scene.layout.FlowPane
import kotfx.internal.ChildManager
import kotfx.internal.ItemManager
import kotfx.internal.LayoutDsl

class _FlowPane : FlowPane(), ChildManager, Marginable {
    override infix fun <N : Node> N.margin(value: Insets): N = apply { setMargin(this, value) }
    override val Node.margin2: Insets get() = getMargin(this) ?: EMPTY

    override fun <N : Node> N.clearConstraints(): N = apply { clearConstraints(this) }
}

inline fun flowPaneOf(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init)
inline fun ChildManager.flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()
inline fun ItemManager.flowPane(init: (@LayoutDsl _FlowPane).() -> Unit): FlowPane = _FlowPane().apply(init).add()