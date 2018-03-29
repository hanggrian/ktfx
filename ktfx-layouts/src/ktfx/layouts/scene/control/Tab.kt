@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

inline fun tab(
    text: String? = null,
    content: Node? = null
): Tab = tab(text, content) { }

inline fun tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl Tab).() -> Unit
): Tab = Tab(text, content).apply(init)

inline fun LayoutManager<Tab>.tab(
    text: String? = null,
    content: Node? = null
): Tab = tab(text, content) { }

inline fun LayoutManager<Tab>.tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl Tab).() -> Unit
): Tab = ktfx.layouts.tab(text, content, init).add()