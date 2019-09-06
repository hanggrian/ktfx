@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.ToolBar

open class _ToolBar : ToolBar(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { items += it }
}

/** Create a [ToolBar] with initialization block. */
inline fun toolBar(
    init: (@LayoutDslMarker _ToolBar).() -> Unit
): ToolBar = _ToolBar().apply(init)

/** Add a [ToolBar] to this manager. */
fun NodeManager.toolBar(): ToolBar =
    addNode(ktfx.layouts.toolBar { })

/** Add a [ToolBar] with initialization block to this manager. */
inline fun NodeManager.toolBar(
    init: (@LayoutDslMarker _ToolBar).() -> Unit
): ToolBar = addNode(ktfx.layouts.toolBar(init))
