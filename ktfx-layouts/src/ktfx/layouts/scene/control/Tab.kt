@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

open class _Tab(title: String?, content: Node?) : Tab(title, content), NodeManager {

    override fun <T : Node> T.add(): T = also { content = it }
}

/** Add a [Tab] to this manager. */
fun TabManager.tab(
    text: String? = null,
    content: Node? = null
): Tab = _Tab(text, content).add()

/** Add a [Tab] with initialization block to this manager. */
inline fun TabManager.tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDslMarker _Tab).() -> Unit
): Tab = (tab(text, content) as _Tab).apply(init)
