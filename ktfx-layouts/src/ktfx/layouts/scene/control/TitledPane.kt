@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane

inline fun titledPane(
    text: String? = null,
    content: Node? = null
): TitledPane = titledPane(text, content) { }

inline fun titledPane(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl TitledPane).() -> Unit
): TitledPane = TitledPane(text, content).apply(init)

inline fun LayoutManager<Node>.titledPane(
    text: String? = null,
    content: Node? = null
): TitledPane = titledPane(text, content) { }

inline fun LayoutManager<Node>.titledPane(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl TitledPane).() -> Unit
): TitledPane = ktfx.layouts.titledPane(text, content, init).add()