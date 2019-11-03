@file:JvmMultifileClass
@file:JvmName("JfoenixLayoutsKt")

package ktfx.thirdparty.jfoenix.layouts

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.control.TreeView
import ktfx.layouts.LayoutDslMarker
import ktfx.layouts.NodeManager
import ktfx.layouts.addNode

/** Create a [JFXTreeViewPath] with initialization block. */
inline fun jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath = JFXTreeViewPath(treeView).apply(init)

/** Add a [JFXTreeViewPath] to this manager. */
fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null
): JFXTreeViewPath = addNode(JFXTreeViewPath(treeView))

/** Add a [JFXTreeViewPath] with initialization block to this manager. */
inline fun NodeManager.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: (@LayoutDslMarker JFXTreeViewPath).() -> Unit
): JFXTreeViewPath = addNode(JFXTreeViewPath(treeView), init)
