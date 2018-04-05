@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

open class _ScrollPane(content: Node?) : ScrollPane(content), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also { content = it }
}

inline fun scrollPane(
    content: Node? = null
): ScrollPane = scrollPane(content) { }

inline fun scrollPane(
    content: Node? = null,
    init: (@LayoutDsl _ScrollPane).() -> Unit
): ScrollPane = _ScrollPane(content).apply(init)

inline fun LayoutManager<Node>.scrollPane(
    content: Node? = null
): ScrollPane = scrollPane(content) { }

inline fun LayoutManager<Node>.scrollPane(
    content: Node? = null,
    init: (@LayoutDsl _ScrollPane).() -> Unit
): ScrollPane = ktfx.layouts.scrollPane(content, init).add()