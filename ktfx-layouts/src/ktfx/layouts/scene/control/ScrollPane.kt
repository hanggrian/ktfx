@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ScrollPane

inline fun scrollPane(
    content: Node? = null
): ScrollPane = scrollPane(content) { }

inline fun scrollPane(
    content: Node? = null,
    init: (@LayoutDsl ScrollPane).() -> Unit
): ScrollPane = ScrollPane(content).apply(init)

inline fun LayoutManager<Node>.scrollPane(
    content: Node? = null
): ScrollPane = scrollPane(content) { }

inline fun LayoutManager<Node>.scrollPane(
    content: Node? = null,
    init: (@LayoutDsl ScrollPane).() -> Unit
): ScrollPane = ktfx.layouts.scrollPane(content, init).add()