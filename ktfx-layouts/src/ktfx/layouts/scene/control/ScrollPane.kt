@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ScrollPane

open class _ScrollPane(
    content: Node?
) : ScrollPane(content), LayoutManager<Node> {

    override operator fun <T : Node> T.invoke(): T = also { content = it }
}

/** Creates a [ScrollPane]. */
fun scrollPane(
    content: Node? = null,
    init: ((@LayoutDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = _ScrollPane(content).also { init?.invoke(it) }

/** Creates a [ScrollPane] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.scrollPane(
    content: Node? = null,
    noinline init: ((@LayoutDsl _ScrollPane).() -> Unit)? = null
): ScrollPane = ktfx.layouts.scrollPane(content, init)()