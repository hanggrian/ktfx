@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

open class _SplitPane : SplitPane(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { items += it }
}

/** Create a [SplitPane] with initialization block. */
inline fun splitPane(
    init: (@LayoutDslMarker _SplitPane).() -> Unit
): SplitPane = _SplitPane().apply(init)

/** Add a [SplitPane] to this manager. */
fun NodeManager.splitPane(): SplitPane =
    addNode(ktfx.layouts.splitPane { })

/** Add a [SplitPane] with initialization block to this manager. */
inline fun NodeManager.splitPane(
    init: (@LayoutDslMarker _SplitPane).() -> Unit
): SplitPane = addNode(ktfx.layouts.splitPane(init))
