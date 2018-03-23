@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Label

inline fun label(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Label).() -> Unit)? = null
): Label = Label(text, graphic).also { init?.invoke(it) }

inline fun LayoutManager<Node>.label(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Label).() -> Unit)? = null
): Label = ktfx.layouts.label(text, graphic, init).add()