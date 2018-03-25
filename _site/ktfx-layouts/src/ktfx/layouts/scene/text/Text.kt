@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text

inline fun text(
    text: String? = null,
    noinline init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = Text(text).also { init?.invoke(it) }

inline fun LayoutManager<Node>.text(
    text: String? = null,
    noinline init: ((@LayoutDsl Text).() -> Unit)? = null
): Text = ktfx.layouts.text(text, init).add()