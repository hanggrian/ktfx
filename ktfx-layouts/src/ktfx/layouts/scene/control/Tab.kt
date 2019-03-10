@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

open class _Tab(title: String?, content: Node?) : Tab(title, content), NodeManager {

    override fun <T : Node> T.add(): T = also { content = it }
}

/** Creates a [Tab]. */
fun tab(
    text: String? = null,
    content: Node? = null,
    init: ((@LayoutMarker _Tab).() -> Unit)? = null
): Tab = _Tab(text, content).also { init?.invoke(it) }

/** Creates a [Tab] and add it to this manager. */
inline fun TabManager.tab(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutMarker _Tab).() -> Unit)? = null
): Tab = ktfx.layouts.tab(text, content, init).add()