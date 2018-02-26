@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.layout

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ButtonBar
import kotfx.annotations.LayoutDsl

interface ButtonManager {

    fun getButtons(): ObservableList<Node>

    fun <T : Node> T.add(): T = apply { getButtons() += this }
}

class _ButtonBar(buttonOrder: String? = null) : ButtonBar(buttonOrder), ButtonManager

inline fun buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = _ButtonBar(buttonOrder).apply { init?.invoke(this) }
inline fun ChildManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = kotfx.layout.buttonBar(buttonOrder, init).add()
inline fun ItemManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = kotfx.layout.buttonBar(buttonOrder, init).add()
inline fun ButtonManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = kotfx.layout.buttonBar(buttonOrder, init).add()