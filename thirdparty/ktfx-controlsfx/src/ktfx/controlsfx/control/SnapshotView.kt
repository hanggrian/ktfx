@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "ClassName")

package ktfx.controlsfx

import javafx.scene.Node
import ktfx.LayoutDsl
import ktfx.NodeInvokable
import org.controlsfx.control.SnapshotView

open class _SnapshotView : SnapshotView(), NodeInvokable {

    override fun <R : Node> R.invoke(): R = also { node = it }
}

/** Creates a [SnapshotView]. */
fun snapshotView(
    init: ((@LayoutDsl _SnapshotView).() -> Unit)? = null
): SnapshotView = _SnapshotView().also { init?.invoke(it) }

/** Creates a [SnapshotView] and add it to this manager. */
inline fun NodeInvokable.snapshotView(
    noinline init: ((@LayoutDsl _SnapshotView).() -> Unit)? = null
): SnapshotView = ktfx.controlsfx.snapshotView(init)()