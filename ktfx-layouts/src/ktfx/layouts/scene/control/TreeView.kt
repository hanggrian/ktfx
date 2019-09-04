@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView

/** Add a [TreeView] to this manager. */
fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null
): TreeView<T> = TreeView(root).add()

/** Add a [TreeView] with initialization block to this manager. */
inline fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker TreeView<T>).() -> Unit
): TreeView<T> = treeView(root).apply(init)
