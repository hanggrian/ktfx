@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.SplitPane
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _SplitPane(vararg items: Node) : SplitPane(*items), NodeManager {

    override fun getChildren(): ObservableList<Node> = items
}

/** Creates a [SplitPane]. */
fun splitPane(
    vararg items: Node,
    init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = _SplitPane(*items).also { init?.invoke(it) }

/** Creates a [SplitPane] and add it to this manager. */
inline fun NodeManager.splitPane(
    vararg items: Node,
    noinline init: ((@LayoutDsl _SplitPane).() -> Unit)? = null
): SplitPane = ktfx.layouts.splitPane(*items, init = init)()