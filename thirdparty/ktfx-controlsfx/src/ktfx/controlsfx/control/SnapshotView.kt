@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl
import org.controlsfx.control.SnapshotView

/** Creates a [SnapshotView]. */
fun snapshotView(
    node: Node? = null,
    init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = SnapshotView(node).also { init?.invoke(it) }

/** Creates a [SnapshotView] and add it to this manager. */
inline fun NodeManager.snapshotView(
    node: Node? = null,
    noinline init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = ktfx.controlsfx.snapshotView(node, init)()