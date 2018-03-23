@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView

inline fun <T> treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = TreeView<T>(root).apply { init?.invoke(this) }
inline fun <T> ChildManager.treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = ktfx.layouts.treeView(root, init).add()
inline fun <T> ItemManager.treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = ktfx.layouts.treeView(root, init).add()
inline fun <T> ButtonManager.treeView(root: TreeItem<T>? = null, noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null): TreeView<T> = ktfx.layouts.treeView(root, init).add()