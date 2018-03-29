@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.layout.FlowPane
import ktfx.layouts.internal.MarginedPane

open class _FlowPane : FlowPane(), LayoutManager<Node>, MarginedPane {

    override infix fun <N : Node> N.margins(value: Insets?): N = apply { setMargin(this, value) }

    override val Node.margins: Insets get() = getMargin(this) ?: Insets.EMPTY

    override fun Node.reset() = clearConstraints(this)

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun flowPane(): FlowPane = flowPane { }

inline fun flowPane(
    init: (@LayoutDsl _FlowPane).() -> Unit
): FlowPane = _FlowPane().apply(init)

inline fun LayoutManager<Node>.flowPane(): FlowPane = flowPane { }

inline fun LayoutManager<Node>.flowPane(
    init: (@LayoutDsl _FlowPane).() -> Unit
): FlowPane = ktfx.layouts.flowPane(init).add()