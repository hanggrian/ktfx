@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.PopOver

open class _PopOver(content: Node? = null) : PopOver(content), LayoutManager<Node> {

    override fun <T : Node> T.invoke(): T = also { contentNode = it }
}

/** Creates a [PopOver]. */
fun popOver(
    content: Node? = null,
    init: ((@LayoutDsl _PopOver).() -> Unit)? = null
): PopOver = _PopOver(content).also {
    init?.invoke(it)
}