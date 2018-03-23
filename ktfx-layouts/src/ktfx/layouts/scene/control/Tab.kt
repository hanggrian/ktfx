@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

inline fun tab(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl Tab).() -> Unit)? = null
): Tab = Tab(text, content).also { init?.invoke(it) }

inline fun LayoutManager<Tab>.tab(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl Tab).() -> Unit)? = null
): Tab = ktfx.layouts.tab(text, content, init).add()