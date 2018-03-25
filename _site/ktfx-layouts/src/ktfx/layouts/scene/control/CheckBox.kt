@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckBox

inline fun checkBox(
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).also { init?.invoke(it) }

inline fun LayoutManager<Node>.checkBox(
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = ktfx.layouts.checkBox(text, init).add()