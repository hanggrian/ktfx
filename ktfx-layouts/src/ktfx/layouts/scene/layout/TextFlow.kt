@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.TextFlow

open class _TextFlow : TextFlow(), LayoutManager<Node> {

    override fun <T : Node> T.add(): T = also { children += it }
}

inline fun textFlow(): TextFlow = textFlow { }
inline fun textFlow(
    init: (@LayoutDsl _TextFlow).() -> Unit
): TextFlow = _TextFlow().apply(init)

inline fun LayoutManager<Node>.textFlow(): TextFlow = textFlow { }
inline fun LayoutManager<Node>.textFlow(
    init: (@LayoutDsl _TextFlow).() -> Unit
): TextFlow = ktfx.layouts.textFlow(init).add()