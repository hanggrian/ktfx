@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView

/** Creates a [TreeView]. */
fun <T> treeView(
    root: TreeItem<T>? = null,
    init: ((@LayoutDslMarker TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).also { init?.invoke(it) }

/** Creates a [TreeView] and add it to this manager. */
inline fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDslMarker TreeView<T>).() -> Unit)? = null
): TreeView<T> = ktfx.layouts.treeView(root, init).add()