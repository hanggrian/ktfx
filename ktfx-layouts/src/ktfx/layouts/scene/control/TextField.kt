@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TextField

inline fun textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = TextField(text).apply { init?.invoke(this) }

inline fun Manager<Node>.textField(text: String = "", noinline init: ((@LayoutDsl TextField).() -> Unit)? = null): TextField = ktfx.layouts.textField(text, init).add()