@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ButtonBar

@Suppress("ClassName")
open class _ButtonBar(buttonOrder: String? = null) : ButtonBar(buttonOrder), LayoutManager<Node> {

    override val childs: ObservableList<Node> get() = buttons
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