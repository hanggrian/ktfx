@file:Suppress("NOTHING_TO_INLINE")

package javafxx.layouts.controlsfx

import javafx.scene.Node
import javafxx.layouts.LayoutDsl
import javafxx.layouts.LayoutManager
import org.controlsfx.control.SnapshotView

/** Creates a [SnapshotView]. */
fun snapshotView(
    node: Node? = null,
    init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = SnapshotView(node).also {
    init?.invoke(it)
}

/** Creates a [SnapshotView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.snapshotView(
    node: Node? = null,
    noinline init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = javafxx.layouts.controlsfx.snapshotView(node, init)()

/** Create a styled [SnapshotView]. */
fun styledSnapshotView(
    styleClass: String,
    node: Node? = null,
    init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = SnapshotView(node).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [SnapshotView] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.styledSnapshotView(
    styleClass: String,
    node: Node? = null,
    noinline init: ((@LayoutDsl SnapshotView).() -> Unit)? = null
): SnapshotView = javafxx.layouts.controlsfx.styledSnapshotView(styleClass, node, init)()