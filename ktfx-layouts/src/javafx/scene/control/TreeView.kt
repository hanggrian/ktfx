@file:JvmMultifileClass
@file:JvmName("LayoutsKt")

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView

/** Create a [TreeView] with initialization block. */
inline fun <T> treeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker TreeView<T>).() -> Unit
): TreeView<T> = TreeView(root).apply(init)

/** Add a [TreeView] to this manager. */
fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null
): TreeView<T> = addNode(TreeView(root))

/** Add a [TreeView] with initialization block to this manager. */
inline fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDslMarker TreeView<T>).() -> Unit
): TreeView<T> = addNode(TreeView(root), init)
