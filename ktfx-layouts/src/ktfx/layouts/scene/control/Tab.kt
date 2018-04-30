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

/** Creates a [Tab]. */
fun tab(
    text: String? = null,
    content: Node? = null,
    init: ((@LayoutDsl _Tab).() -> Unit)? = null
): Tab = _Tab(text, content).also {
    init?.invoke(it)
}

/** Creates a [Tab] and add it to this [LayoutManager]. */
inline fun LayoutManager<Tab>.tab(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl _Tab).() -> Unit)? = null
): Tab = ktfx.layouts.tab(text, content, init).add()

/** Create a styled [Tab]. */
fun styledTab(
    styleClass: String,
    text: String? = null,
    content: Node? = null,
    init: ((@LayoutDsl _Tab).() -> Unit)? = null
): Tab = _Tab(text, content).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [Tab] and add it to this [LayoutManager]. */
inline fun LayoutManager<Tab>.styledTab(
    styleClass: String,
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl _Tab).() -> Unit)? = null
): Tab = ktfx.layouts.styledTab(styleClass, text, content, init).add()