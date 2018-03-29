@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ButtonBar

@Suppress("ClassName")
open class _ButtonBar(buttonOrder: String? = null) : ButtonBar(buttonOrder), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also { buttons += it }
}

inline fun buttonBar(
    buttonOrder: String? = null
): ButtonBar = buttonBar(buttonOrder) { }

inline fun buttonBar(
    buttonOrder: String? = null,
    init: (@LayoutDsl _ButtonBar).() -> Unit
): ButtonBar = _ButtonBar(buttonOrder).apply(init)

inline fun LayoutManager<Node>.buttonBar(
    buttonOrder: String? = null
): ButtonBar = buttonBar(buttonOrder) { }

inline fun LayoutManager<Node>.buttonBar(
    buttonOrder: String? = null,
    init: (@LayoutDsl _ButtonBar).() -> Unit
): ButtonBar = ktfx.layouts.buttonBar(buttonOrder, init).add()