@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView

inline fun <T> treeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).also { init?.invoke(it) }

inline fun <T> LayoutManager<Node>.treeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = ktfx.layouts.treeView(root, init).add()