@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SnapshotView

open class _SnapshotView : SnapshotView(), NodeManager {

    override fun <T : Node> addNode(node: T): T = node.also { this.node = it }
}

/** Create a [SnapshotView] with initialization block. */
inline fun snapshotView(
    init: (@LayoutDslMarker _SnapshotView).() -> Unit
): SnapshotView = _SnapshotView().apply(init)

/** Add a [SnapshotView] to this manager. */
fun NodeManager.snapshotView(): SnapshotView =
    addNode(ktfx.controlsfx.snapshotView { })

/** Add a [SnapshotView] with initialization block to this manager. */
inline fun NodeManager.snapshotView(
    init: (@LayoutDslMarker _SnapshotView).() -> Unit
): SnapshotView = addNode(ktfx.controlsfx.snapshotView(init))
