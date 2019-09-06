@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

open class _Tab(title: String?, content: Node?) : Tab(title, content), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { content = it }
}

/** Create a [Tab] with initialization block. */
inline fun tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDslMarker _Tab).() -> Unit
): Tab = _Tab(text, content).apply(init)

/** Add a [Tab] to this manager. */
fun TabManager.tab(
    text: String? = null,
    content: Node? = null
): Tab = addTab(ktfx.layouts.tab(text, content) { })

/** Add a [Tab] with initialization block to this manager. */
inline fun TabManager.tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDslMarker _Tab).() -> Unit
): Tab = addTab(ktfx.layouts.tab(text, content, init))
