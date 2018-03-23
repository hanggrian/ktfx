@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.ButtonBar

@Suppress("ClassName")
open class _ButtonBar(buttonOrder: String? = null) : ButtonBar(buttonOrder), ButtonManager

inline fun buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = _ButtonBar(buttonOrder).apply { init?.invoke(this) }
inline fun ChildManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = ktfx.layouts.buttonBar(buttonOrder, init).add()
inline fun ItemManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = ktfx.layouts.buttonBar(buttonOrder, init).add()
inline fun ButtonManager.buttonBar(buttonOrder: String? = null, noinline init: ((@LayoutDsl _ButtonBar).() -> Unit)? = null): ButtonBar = ktfx.layouts.buttonBar(buttonOrder, init).add()