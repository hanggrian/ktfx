@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

inline fun scrollPane(
    content: Node? = null,
    noinline init: ((@LayoutDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ScrollPane(content).also { init?.invoke(it) }

inline fun LayoutManager<Node>.scrollPane(
    content: Node? = null,
    noinline init: ((@LayoutDsl ScrollPane).() -> Unit)? = null
): ScrollPane = ktfx.layouts.scrollPane(content, init).add()