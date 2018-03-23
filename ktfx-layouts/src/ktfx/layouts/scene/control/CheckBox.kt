@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckBox

inline fun checkBox(
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).apply { init?.invoke(this) }

inline fun Manager<Node>.checkBox(
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = ktfx.layouts.checkBox(text, init).add()