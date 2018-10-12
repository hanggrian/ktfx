@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView

/** Creates a [TreeTableView]. */
fun <S> treeTableView(
    root: TreeItem<S>? = null,
    init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).also { init?.invoke(it) }

/** Creates a [TreeTableView] and add it to this [LayoutManager]. */
inline fun <S> LayoutManager<Node>.treeTableView(
    root: TreeItem<S>? = null,
    noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = ktfx.layouts.treeTableView(root, init)()