@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Add a [JFXTreeViewPath] to this manager. */
fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null
): JFXTreeViewPath = JFXTreeViewPath(treeView).add()

/** Add a [JFXTreeViewPath] with initialization block to this manager. */
inline fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath = jfxTreeViewPath(treeView).apply(init)
