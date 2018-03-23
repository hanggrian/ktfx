@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.FlowPane

open class _FlowPane : FlowPane(), ChildLayoutManager, MarginedPane {

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)
}

inline fun flowPane(
    noinline init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = _FlowPane().also { init?.invoke(it) }

inline fun LayoutManager<Node>.flowPane(
    noinline init: ((@LayoutDsl _FlowPane).() -> Unit)? = null
): FlowPane = ktfx.layouts.flowPane(init).add()