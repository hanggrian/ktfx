@file:Suppress("PackageDirectoryMismatch")

package ktfx.jfoenix

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager

/** Create a [JFXTreeViewPath] with initialization block. */
inline fun jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath = JFXTreeViewPath(treeView).apply(init)

/** Add a [JFXTreeViewPath] to this manager. */
fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null
): JFXTreeViewPath = addNode(ktfx.jfoenix.jfxTreeViewPath(treeView) { })

/** Add a [JFXTreeViewPath] with initialization block to this manager. */
inline fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath = addNode(ktfx.jfoenix.jfxTreeViewPath(treeView, init))
