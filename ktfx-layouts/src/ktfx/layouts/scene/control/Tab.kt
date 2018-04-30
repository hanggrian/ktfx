@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

open class _Tab(
    title: String?,
    content: Node?
) : Tab(title, content), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also { content = it }
}

inline fun tab(
    text: String? = null,
    content: Node? = null
): Tab = tab(text, content) { }

inline fun tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl _Tab).() -> Unit
): Tab = _Tab(text, content).apply(init)

inline fun LayoutManager<Tab>.tab(
    text: String? = null,
    content: Node? = null
): Tab = tab(text, content) { }

inline fun LayoutManager<Tab>.tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl _Tab).() -> Unit
): Tab = ktfx.layouts.tab(text, content, init).add()