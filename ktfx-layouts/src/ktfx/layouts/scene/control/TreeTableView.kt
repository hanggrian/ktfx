@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView
import ktfx.NodeManager
import ktfx.annotations.LayoutDsl

/** Creates a [TreeTableView]. */
fun <S> treeTableView(
    root: TreeItem<S>? = null,
    init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).also { init?.invoke(it) }

/** Creates a [TreeTableView] and add it to this manager. */
inline fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null,
    noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = ktfx.layouts.treeTableView(root, init)()