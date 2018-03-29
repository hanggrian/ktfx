@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text

inline fun text(
    text: String? = null
): Text = text(text) { }

inline fun text(
    text: String? = null,
    init: (@LayoutDsl Text).() -> Unit
): Text = Text(text).apply(init)

inline fun LayoutManager<Node>.text(
    text: String? = null
): Text = text(text) { }

inline fun LayoutManager<Node>.text(
    text: String? = null,
    init: (@LayoutDsl Text).() -> Unit
): Text = ktfx.layouts.text(text, init).add()