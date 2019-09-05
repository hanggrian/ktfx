@file:Suppress("PackageDirectoryMismatch", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SnapshotView

open class _SnapshotView : SnapshotView(), NodeManager {

    override fun <R : Node> R.add(): R = also { node = it }
}

/** Add a [SnapshotView] to this manager. */
fun NodeManager.snapshotView(): SnapshotView =
    _SnapshotView().add()

/** Add a [SnapshotView] with initialization block to this manager. */
inline fun NodeManager.snapshotView(
    init: (@LayoutDslMarker _SnapshotView).() -> Unit
): SnapshotView = (snapshotView() as _SnapshotView).apply(init)
