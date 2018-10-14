@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [TreeView]. */
fun <T> treeView(
    root: TreeItem<T>? = null,
    init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = TreeView<T>(root).also { init?.invoke(it) }

/** Creates a [TreeView] and add it to this manager. */
inline fun <T> NodeManager.treeView(
    root: TreeItem<T>? = null,
    noinline init: ((@LayoutDsl TreeView<T>).() -> Unit)? = null
): TreeView<T> = ktfx.layouts.treeView(root, init)()