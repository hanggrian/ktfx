@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.layouts.LayoutMarker
import ktfx.layouts.NodeManager
import org.controlsfx.control.SnapshotView

open class _SnapshotView : SnapshotView(), NodeManager {

    override fun <R : Node> R.add(): R = also { node = it }
}

/** Creates a [SnapshotView]. */
fun snapshotView(
    init: ((@LayoutMarker _SnapshotView).() -> Unit)? = null
): SnapshotView = _SnapshotView().also { init?.invoke(it) }

/** Creates a [SnapshotView] and add it to this manager. */
inline fun NodeManager.snapshotView(
    noinline init: ((@LayoutMarker _SnapshotView).() -> Unit)? = null
): SnapshotView = ktfx.controlsfx.snapshotView(init).add()