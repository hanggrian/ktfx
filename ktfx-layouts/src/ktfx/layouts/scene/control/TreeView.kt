@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView

/** Creates a [TreeView]. */
fun <T> treeView(
    root: TreeItem<T>? = null,
    init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).also {
    init?.invoke(it)
}

/** Creates a [TreeView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.treeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = ktfx.layouts.treeView(root, init)()

/** Create a styled [TreeView]. */
fun <T> styledTreeView(
    styleClass: String,
    root: TreeItem<T>? = null,
    init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TreeView] and add it to this [LayoutManager]. */
inline fun <T> LayoutManager<Node>.styledTreeView(
    styleClass: String,
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = ktfx.layouts.styledTreeView(styleClass, root, init)()