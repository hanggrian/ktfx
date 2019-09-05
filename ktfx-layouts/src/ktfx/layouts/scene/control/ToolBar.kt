@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar

open class _ToolBar : ToolBar(), NodeManager {

    override fun <R : Node> R.add(): R = also { items += it }
}

/** Add a [ToolBar] to this manager. */
fun NodeManager.toolBar(): ToolBar =
    _ToolBar().add()

/** Add a [ToolBar] with initialization block to this manager. */
inline fun NodeManager.toolBar(
    init: (@LayoutDslMarker _ToolBar).() -> Unit
): ToolBar = (toolBar() as _ToolBar).apply(init)
