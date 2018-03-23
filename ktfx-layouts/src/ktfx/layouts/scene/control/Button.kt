@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button

inline fun button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = Button(text, graphic).apply { init?.invoke(this) }
inline fun ChildManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = ktfx.layouts.button(text, graphic, init).add()
inline fun ItemManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = ktfx.layouts.button(text, graphic, init).add()
inline fun ButtonManager.button(text: String? = null, graphic: Node? = null, noinline init: ((@LayoutDsl Button).() -> Unit)? = null): Button = ktfx.layouts.button(text, graphic, init).add()