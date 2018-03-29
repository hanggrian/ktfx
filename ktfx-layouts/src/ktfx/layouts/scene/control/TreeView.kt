@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView

inline fun <T> treeView(
    root: TreeItem<T>? = null
): TreeView<T> = treeView(root) { }

inline fun <T> treeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDsl TreeView<T>).() -> Unit
): TreeView<T> = TreeView<T>(root).apply(init)

inline fun <T> LayoutManager<Node>.treeView(
    root: TreeItem<T>? = null
): TreeView<T> = treeView(root) { }

inline fun <T> LayoutManager<Node>.treeView(
    root: TreeItem<T>? = null,
    init: (@LayoutDsl TreeView<T>).() -> Unit
): TreeView<T> = ktfx.layouts.treeView(root, init).add()