@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ButtonBar

@Suppress("ClassName")
open class _ButtonBar(buttonOrder: String? = null) : ButtonBar(buttonOrder), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also { buttons += it }
}

inline fun buttonBar(
    buttonOrder: String? = null,
    noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = _ButtonBar(buttonOrder).also { init?.invoke(it) }

inline fun LayoutManager<Node>.buttonBar(
    buttonOrder: String? = null,
    noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null
): ButtonBar = ktfx.layouts.buttonBar(buttonOrder, init).add()