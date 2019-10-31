@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.SplitPane

open class KtfxSplitPane : SplitPane(), NodeManager {

    final override fun <T : Node> addNode(node: T): T =
        node.also { items += it }
}

/** Create a [SplitPane] with initialization block. */
inline fun splitPane(
    init: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane = KtfxSplitPane().apply(init)

/** Add a [SplitPane] to this manager. */
fun NodeManager.splitPane(): SplitPane =
    addNode(KtfxSplitPane())

/** Add a [SplitPane] with initialization block to this manager. */
inline fun NodeManager.splitPane(
    init: (@LayoutDslMarker KtfxSplitPane).() -> Unit
): SplitPane = addNode(KtfxSplitPane(), init)
