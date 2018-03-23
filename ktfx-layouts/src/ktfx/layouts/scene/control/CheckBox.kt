@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.CheckBox

inline fun checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = CheckBox(text).apply { init?.invoke(this) }
inline fun ChildManager.checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = ktfx.layouts.checkBox(text, init).add()
inline fun ItemManager.checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = ktfx.layouts.checkBox(text, init).add()
inline fun ButtonManager.checkBox(text: String? = null, noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null): CheckBox = ktfx.layouts.checkBox(text, init).add()