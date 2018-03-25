@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane

inline fun titledPane(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl TitledPane).() -> Unit)? = null
): TitledPane = TitledPane(text, content).also { init?.invoke(it) }

inline fun LayoutManager<Node>.titledPane(
    text: String? = null,
    content: Node? = null,
    noinline init: ((@LayoutDsl TitledPane).() -> Unit)? = null
): TitledPane = ktfx.layouts.titledPane(text, content, init).add()