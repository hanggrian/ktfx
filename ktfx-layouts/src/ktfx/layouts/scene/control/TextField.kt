@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TextField

inline fun textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }
inline fun ChildManager.textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = ktfx.layouts.textField(text, init).add()
inline fun ItemManager.textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = ktfx.layouts.textField(text, init).add()
inline fun ButtonManager.textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = ktfx.layouts.textField(text, init).add()