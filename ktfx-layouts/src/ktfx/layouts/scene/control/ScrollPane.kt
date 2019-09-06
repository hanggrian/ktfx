@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

open class _ScrollPane(content: Node?) : ScrollPane(content), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { content = it }
}

/** Create a [ScrollPane] with initialization block. */
inline fun scrollPane(
    content: Node? = null,
    init: (@LayoutDslMarker _ScrollPane).() -> Unit
): ScrollPane = _ScrollPane(content).apply(init)

/** Add a [ScrollPane] to this manager. */
fun NodeManager.scrollPane(
    content: Node? = null
): ScrollPane = addNode(ktfx.layouts.scrollPane(content) { })

/** Add a [ScrollPane] with initialization block to this manager. */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    init: (@LayoutDslMarker _ScrollPane).() -> Unit
): ScrollPane = addNode(ktfx.layouts.scrollPane(content, init))
