@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow

open class _TextFlow(
    vararg children: Node
) : TextFlow(*children), LayoutManager<Node> {

    override val childs: MutableCollection<Node> get() = children

    /** Creates a [Text] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        noinline init: ((@LayoutDsl Text).() -> Unit)? = null
    ): Text = text(this, init)

    /** Creates a styled [Text] and add it to this [LayoutManager]. */
    inline operator fun String.invoke(
        styleClass: String,
        noinline init: ((@LayoutDsl Text).() -> Unit)? = null
    ): Text = styledText(styleClass, this, init)
}

/** Creates a [TextFlow]. */
fun textFlow(
    vararg children: Node,
    init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = _TextFlow(*children).also {
    init?.invoke(it)
}

/** Creates a [TextFlow] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.textFlow(
    vararg children: Node,
    noinline init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = javafxx.layouts.textFlow(*children, init = init)()

/** Create a styled [TextFlow]. */
fun styledTextFlow(
    styleClass: String,
    vararg children: Node,
    init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = _TextFlow(*children).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TextFlow] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledTextFlow(
    styleClass: String,
    vararg children: Node,
    noinline init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = javafxx.layouts.styledTextFlow(styleClass, *children, init = init)()