@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TitledPane

open class _TitledPane(title: String?, content: Node?) : TitledPane(title, content), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also { content = it }
}

inline fun titledPane(
    text: String? = null,
    content: Node? = null
): TitledPane = titledPane(text, content) { }

inline fun titledPane(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl _TitledPane).() -> Unit
): TitledPane = _TitledPane(text, content).apply(init)

inline fun LayoutManager<Node>.titledPane(
    text: String? = null,
    content: Node? = null
): TitledPane = titledPane(text, content) { }

inline fun LayoutManager<Node>.titledPane(
    text: String? = null,
    content: Node? = null,
    init: (@LayoutDsl _TitledPane).() -> Unit
): TitledPane = ktfx.layouts.titledPane(text, content, init).add()