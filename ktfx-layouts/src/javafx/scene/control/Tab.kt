@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.Tab

open class KtfxTab(title: String?, content: Node?) : Tab(title, content), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { content = it }
}

/** Create a [Tab] with initialization block. */
inline fun tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab = KtfxTab(text, content).apply(init)

/** Add a [Tab] to this manager. */
fun TabManager.tab(
    text: String? = null,
    content: Node? = null
): Tab = addTab(KtfxTab(text, content))

/** Add a [Tab] with initialization block to this manager. */
inline fun TabManager.tab(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDslMarker KtfxTab).() -> Unit
): Tab = addTab(KtfxTab(text, content), init)
