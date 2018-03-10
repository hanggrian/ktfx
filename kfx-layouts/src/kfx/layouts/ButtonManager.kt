@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ButtonBar

interface ButtonManager {

    fun getButtons(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getButtons() += this }
}

class _ButtonBar(buttonOrder: String? = null) : ButtonBar(buttonOrder), ButtonManager

inline fun buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = _ButtonBar(buttonOrder).apply { init?.invoke(this) }
inline fun ChildManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = kfx.layouts.buttonBar(buttonOrder, init).add()
inline fun ItemManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = kfx.layouts.buttonBar(buttonOrder, init).add()
inline fun ButtonManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = kfx.layouts.buttonBar(buttonOrder, init).add()