@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.TextArea

/** Creates a [TextArea]. */
fun textArea(
    text: String = "",
    init: ((@LayoutDsl TextArea).() -> Unit)? = null
): TextArea = TextArea(text).also {
    init?.invoke(it)
}

/** Creates a [TextArea] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.textArea(
    text: String = "",
    noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null
): TextArea = javafxx.layouts.textArea(text, init)()

/** Create a styled [TextArea]. */
fun styledTextArea(
    styleClass: String,
    text: String = "",
    init: ((@LayoutDsl TextArea).() -> Unit)? = null
): TextArea = TextArea(text).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TextArea] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledTextArea(
    styleClass: String,
    text: String = "",
    noinline init: ((@LayoutDsl TextArea).() -> Unit)? = null
): TextArea = javafxx.layouts.styledTextArea(styleClass, text, init)()