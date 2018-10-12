@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.jfoenix

/* ktlint-enable package-name */

import com.jfoenix.controls.JFXTreeViewPath
import javafx.scene.Node
import javafx.scene.control.TreeView
import ktfx.layouts.LayoutDsl
import ktfx.layouts.LayoutManager

/** Creates a [JFXTreeViewPath]. */
fun jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    init: ((@LayoutDsl JFXTreeViewPath).() -> Unit)? = null
): JFXTreeViewPath = JFXTreeViewPath(treeView).also { init?.invoke(it) }

/** Creates a [JFXTreeViewPath] and add it to this [LayoutManager]. */
inline fun LayoutManager<Node>.jfxTreeViewPath(
    treeView: TreeView<*>? = null,
    noinline init: ((@LayoutDsl JFXTreeViewPath).() -> Unit)? = null
): JFXTreeViewPath = ktfx.jfoenix.jfxTreeViewPath(treeView, init)()