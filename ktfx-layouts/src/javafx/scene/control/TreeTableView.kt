@file:JvmMultifileClass
@file:JvmName("LayoutsKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.layouts

import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableView

/** Create a [TreeTableView] with initialization block. */
inline fun <S> treeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> = TreeTableView(root).apply(init)

/** Add a [TreeTableView] to this manager. */
fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null
): TreeTableView<S> = addNode(TreeTableView(root))

/** Add a [TreeTableView] with initialization block to this manager. */
inline fun <S> NodeManager.treeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDslMarker TreeTableView<S>).() -> Unit
): TreeTableView<S> = addNode(TreeTableView(root), init)
