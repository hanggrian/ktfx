@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.CheckBox

/** Creates a [CheckBox]. */
fun checkBox(
    text: String? = null,
    init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).also {
    init?.invoke(it)
}

/** Creates a [CheckBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.checkBox(
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = javafxx.layouts.checkBox(text, init)()

/** Create a styled [CheckBox]. */
fun styledCheckBox(
    styleClass: String,
    text: String? = null,
    init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = CheckBox(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [CheckBox] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledCheckBox(
    styleClass: String,
    text: String? = null,
    noinline init: ((@LayoutDsl CheckBox).() -> Unit)? = null
): CheckBox = javafxx.layouts.styledCheckBox(styleClass, text, init)()