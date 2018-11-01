@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar
import ktfx.LayoutDsl
import ktfx.NodeManager

open class _ToolBar : ToolBar(), NodeManager {

    override fun <R : Node> R.invoke(): R = also { items += it }
}

/** Creates a [ToolBar]. */
fun toolBar(
    init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = _ToolBar().also { init?.invoke(it) }

/** Creates a [ToolBar] and add it to this manager. */
inline fun NodeManager.toolBar(
    noinline init: ((@LayoutDsl _ToolBar).() -> Unit)? = null
): ToolBar = ktfx.layouts.toolBar(init)()