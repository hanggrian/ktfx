@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.text.TextFlow

open class _TextFlow : TextFlow(), ChildLayoutManager

inline fun textFlow(
    noinline init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = _TextFlow().also { init?.invoke(it) }

inline fun LayoutManager<Node>.textFlow(
    noinline init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = ktfx.layouts.textFlow(init).add()