@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckBox

inline fun checkBox(
    text: String? = null
): CheckBox = checkBox(text) { }

inline fun checkBox(
    text: String? = null,
    init: (@LayoutDsl CheckBox).() -> Unit
): CheckBox = CheckBox(text).apply(init)

inline fun LayoutManager<Node>.checkBox(
    text: String? = null
): CheckBox = checkBox(text) { }

inline fun LayoutManager<Node>.checkBox(
    text: String? = null,
    init: (@LayoutDsl CheckBox).() -> Unit
): CheckBox = ktfx.layouts.checkBox(text, init).add()