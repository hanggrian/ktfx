@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Hyperlink

inline fun hyperlink(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = Hyperlink(text, graphic).also { init?.invoke(it) }

inline fun LayoutManager<Node>.hyperlink(
    text: String? = null,
    graphic: Node? = null,
    noinline init: ((@LayoutDsl Hyperlink).() -> Unit)? = null
): Hyperlink = ktfx.layouts.hyperlink(text, graphic, init).add()