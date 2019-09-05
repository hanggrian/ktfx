@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

open class _ScrollPane(content: Node?) : ScrollPane(content), NodeManager {

    override fun <T : Node> T.add(): T = also { content = it }
}

/** Add a [ScrollPane] to this manager. */
fun NodeManager.scrollPane(
    content: Node? = null
): ScrollPane = _ScrollPane(content).add()

/** Add a [ScrollPane] with initialization block to this manager. */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    init: (@LayoutDslMarker _ScrollPane).() -> Unit
): ScrollPane = (scrollPane(content) as _ScrollPane).apply(init)
