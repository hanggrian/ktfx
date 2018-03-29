@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TextArea

inline fun textArea(
    text: String = ""
): TextArea = textArea(text) { }

inline fun textArea(
    text: String = "",
    init: (@LayoutDsl TextArea).() -> Unit
): TextArea = TextArea(text).apply(init)

inline fun LayoutManager<Node>.textArea(
    text: String = ""
): TextArea = textArea(text) { }

inline fun LayoutManager<Node>.textArea(
    text: String = "",
    init: (@LayoutDsl TextArea).() -> Unit
): TextArea = ktfx.layouts.textArea(text, init).add()