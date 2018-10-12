@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.controlsfx

/* ktlint-enable package-name */

import javafx.scene.Node
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager
import org.controlsfx.control.SnapshotView

/** Creates a [SnapshotView]. */
fun snapshotView(
    node: Node? = null,
    init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = SnapshotView(node).also { init?.invoke(it) }

/** Creates a [SnapshotView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.snapshotView(
    node: Node? = null,
    noinline init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = ktfx.controlsfx.snapshotView(node, init)()