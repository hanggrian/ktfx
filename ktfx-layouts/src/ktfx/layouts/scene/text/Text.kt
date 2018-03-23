@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.Text

inline fun text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = Text(text).apply { init?.invoke(this) }

inline fun Manager<Node>.text(text: String? = null, noinline init: ((@LayoutDsl Text).() -> Unit)? = null): Text = ktfx.layouts.text(text, init).add()