@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

open class _SplitPane : SplitPane(), NodeManager {

    override fun <R : Node> R.add(): R = also { items += it }
}

/** Add a [SplitPane] to this manager. */
fun NodeManager.splitPane(): SplitPane =
    SplitPane().add()

/** Add a [SplitPane] with initialization block to this manager. */
inline fun NodeManager.splitPane(
    init: (@LayoutDslMarker _SplitPane).() -> Unit
): SplitPane = (splitPane() as _SplitPane).apply(init)
