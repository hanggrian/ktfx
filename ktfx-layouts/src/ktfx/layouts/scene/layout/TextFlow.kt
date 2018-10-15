@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.text.Text
import javafx.scene.text.TextFlow
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _TextFlow(vararg children: Node) : TextFlow(*children), NodeManager {

    override val collection: MutableCollection<Node> get() = children

    /** Creates a [Text] and add it to this manager. */
    inline operator fun String.invoke(
        noinline init: ((@LayoutDsl Text).() -> Unit)? = null
    ): Text = text(this, init)

    inline fun newLine(): Text = text(System.lineSeparator())
}

/** Creates a [TextFlow]. */
fun textFlow(
    vararg children: Node,
    init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = _TextFlow(*children).also { init?.invoke(it) }

/** Creates a [TextFlow] and add it to this manager. */
inline fun NodeManager.textFlow(
    vararg children: Node,
    noinline init: ((@LayoutDsl _TextFlow).() -> Unit)? = null
): TextFlow = ktfx.layouts.textFlow(*children, init = init)()