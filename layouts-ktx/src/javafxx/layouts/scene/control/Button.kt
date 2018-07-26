@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts

import javafx.scene.Node
import javafx.scene.control.Button

/** Creates a [Button]. */
fun button(
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).also {
    init?.invoke(it)
}

/** Creates a [Button] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.button(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = javafxx.layouts.button(text, graphic, init)()

/** Create a styled [Button]. */
fun styledButton(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = Button(text, graphic).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Button] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledButton(
    styleClass: String,
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Button).() -> Unit)? = null
): Button = javafxx.layouts.styledButton(styleClass, text, graphic, init)()