@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Button

inline fun button(
    text: String? = null,
    graphic: Node? = null
): Button = button(text, graphic) { }

inline fun button(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl Button).() -> Unit
): Button = Button(text, graphic).apply(init)

inline fun LayoutManager<Node>.button(
    text: String? = null,
    graphic: Node? = null
): Button = button(text, graphic) { }

inline fun LayoutManager<Node>.button(
    text: String? = null,
    graphic: Node? = null,
    init: (@LayoutDsl Button).() -> Unit
): Button = ktfx.layouts.button(text, graphic, init).add()