@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView

/** Add a [TreeTableView] to this manager. */
fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null
): TreeTableView<S> = TreeTableView(root).add()

/** Add a [TreeTableView] with initialization block to this manager. */
inline fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> = treeTableView(root).apply(init)
