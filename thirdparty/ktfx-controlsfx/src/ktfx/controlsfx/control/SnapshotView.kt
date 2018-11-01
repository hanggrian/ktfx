@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeManager
import org.controlsfx.control.SnapshotView

open class _SnapshotView : SnapshotView(), NodeManager {

    override fun <R : Node> R.invoke(): R = also { node = it }
}

/** Creates a [SnapshotView]. */
fun snapshotView(
    init: ((@LayoutDsl _SnapshotView).() -> Unit)? = null
): SnapshotView = _SnapshotView().also { init?.invoke(it) }

/** Creates a [SnapshotView] and add it to this manager. */
inline fun NodeManager.snapshotView(
    noinline init: ((@LayoutDsl _SnapshotView).() -> Unit)? = null
): SnapshotView = ktfx.controlsfx.snapshotView(init)()