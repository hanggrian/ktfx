@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.ToolBar
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _ToolBar(vararg items: Node) : ToolBar(*items), NodeManager {

    override fun getChildren(): ObservableList<Node> = items
}

/** Creates a [ToolBar]. */
fun toolBar(
    vararg items: Node,
    init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar(*items).also { init?.invoke(it) }

/** Creates a [ToolBar] and add it to this manager. */
inline fun NodeManager.toolBar(
    vararg items: Node,
    noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = ktfx.layouts.toolBar(*items, init = init)()