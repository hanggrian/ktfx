@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

open class _TextFlow(
    vararg children: Node
) : TextFlow(*children), LayoutManager<Node> {

    override val childs: ObservableList<Node> get() = children

    /** Convenient method to add text to this flow by only using string. */
    inline operator fun String.invoke(): Text = text(this)

    /** Convenient method to add text to this flow by only using string. */
    inline operator fun String.invoke(init: (@LayoutDsl Text).() -> Unit): Text = text(this, init)
}

/** Create a [TextFlow]. */
inline fun textFlow(
    vararg children: Node
): TextFlow = textFlow(*children) { }

/** Create a [TextFlow] with initialization. */
inline fun textFlow(
    vararg children: Node,
    init: (@LayoutDsl _TextFlow).() -> Unit
): TextFlow = _TextFlow(*children).apply(init)

/** Create a [TextFlow] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.textFlow(
    vararg children: Node
): TextFlow = textFlow(*children) { }

/** Create a [TextFlow] with initialization and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.textFlow(
    vararg children: Node,
    init: (@LayoutDsl _TextFlow).() -> Unit
): TextFlow = ktfx.layouts.textFlow(*children, init = init).add()