@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

open class _ScrollPane(content: Node?) : ScrollPane(content), NodeManager {

    override fun <T : Node> T.add(): T = also { content = it }
}

/** Creates a [ScrollPane]. */
fun scrollPane(
    content: Node? = null,
    init: ((@LayoutMarker _ScrollPane).() -> Unit)? = null
): ScrollPane = _ScrollPane(content).also { init?.invoke(it) }

/** Creates a [ScrollPane] and add it to this manager. */
inline fun NodeManager.scrollPane(
    content: Node? = null,
    noinline init: ((@LayoutMarker _ScrollPane).() -> Unit)? = null
): ScrollPane = ktfx.layouts.scrollPane(content, init).add()