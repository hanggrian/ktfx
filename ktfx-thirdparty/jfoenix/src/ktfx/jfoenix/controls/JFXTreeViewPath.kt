@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import ktfx.layouts.NodeManager
import ktfx.layouts.LayoutMarker

/** Creates a [JFXTreeViewPath]. */
fun jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: ((@LayoutMarker JFXTreeViewPath).() -> Unit)? = null
): JFXTreeViewPath = JFXTreeViewPath(treeView).also { init?.invoke(it) }

/** Creates a [JFXTreeViewPath] and add it to this manager. */
inline fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    noinline init: ((@LayoutMarker JFXTreeViewPath).() -> Unit)? = null
): JFXTreeViewPath = ktfx.jfoenix.jfxTreeViewPath(treeView, init).add()