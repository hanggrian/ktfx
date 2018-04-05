@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

open class _TextFlow : TextFlow(), LayoutManager<Node> {

    override val childs: ObservableList<Node> get() = children

    /** Convenient method to add text to this flow by only using string. */
    inline operator fun String.invoke(): Text = text(this)

    /** Convenient method to add text to this flow by only using string. */
    inline operator fun String.invoke(init: (@LayoutDsl Text).() -> Unit): Text = text(this, init)
}

inline fun textFlow(): TextFlow = textFlow { }

inline fun textFlow(
    init: (@LayoutDsl _TextFlow).() -> Unit
): TextFlow = _TextFlow().apply(init)

inline fun LayoutManager<Node>.textFlow(): TextFlow = textFlow { }

inline fun LayoutManager<Node>.textFlow(
    init: (@LayoutDsl _TextFlow).() -> Unit
): TextFlow = ktfx.layouts.textFlow(init).add()