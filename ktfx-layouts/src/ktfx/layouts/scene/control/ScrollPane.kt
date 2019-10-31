@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

open class KtfxScrollPane(content: Node?) : ScrollPane(content), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [ScrollPane] with initialization block. */
inline fun scrollPane(
    content: Node? = null,
    init: (@LayoutDslMarker KtfxScrollPane).() -> Unit
): ScrollPane = KtfxScrollPane(content).apply(init)

/** Add a [ScrollPane] to this manager. */
fun NodeManager.scrollPane(
    content: Node? = null
): ScrollPane = addNode(KtfxScrollPane(content))

/** Add a [ScrollPane] with initialization block to this manager. */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    init: (@LayoutDslMarker KtfxScrollPane).() -> Unit
): ScrollPane = addNode(KtfxScrollPane(content), init)
