@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.ToolBar
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

open class _ToolBar : ToolBar(), NodeManager {

    override val collection: MutableCollection<Node> get() = items
}

/** Creates a [ToolBar]. */
fun toolBar(
    init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar().also { init?.invoke(it) }

/** Creates a [ToolBar] and add it to this manager. */
inline fun NodeManager.toolBar(
    noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = ktfx.layouts.toolBar(init)()