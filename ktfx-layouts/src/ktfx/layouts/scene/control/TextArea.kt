@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TextArea

inline fun textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = TextArea(text).apply { init?.invoke(this) }
inline fun ChildManager.textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = ktfx.layouts.textArea(text, init).add()
inline fun ItemManager.textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = ktfx.layouts.textArea(text, init).add()
inline fun ButtonManager.textArea(text: String = "", noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null): TextArea = ktfx.layouts.textArea(text, init).add()