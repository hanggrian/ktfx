@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.text.Text

inline fun text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }
inline fun ChildManager.text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = ktfx.layouts.text(text, init).add()
inline fun ItemManager.text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = ktfx.layouts.text(text, init).add()
inline fun ButtonManager.text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = ktfx.layouts.text(text, init).add()