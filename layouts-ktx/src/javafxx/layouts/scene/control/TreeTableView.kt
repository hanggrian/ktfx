@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package javafxx.layouts

/* ktlint-enable package-name */

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import javafxx.layouts.internal._TreeTableColumnsBuilder

/** Creates a [TreeTableView]. */
fun <S> treeTableView(
    root: TreeItem<S>? = null,
    init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).also {
    init?.invoke(it)
}

/** Creates a [TreeTableView] and add it to this [LayoutManager]. */
inline fun <S> LayoutManager<Node>.treeTableView(
    root: TreeItem<S>? = null,
    noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = javafxx.layouts.treeTableView(root, init)()

/** Create a styled [TreeTableView]. */
fun <S> styledTreeTableView(
    styleClass: String,
    root: TreeItem<S>? = null,
    init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = TreeTableView<S>(root).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TreeTableView] and add it to this [LayoutManager]. */
inline fun <S> LayoutManager<Node>.styledTreeTableView(
    styleClass: String,
    root: TreeItem<S>? = null,
    noinline init: ((@LayoutDsl TreeTableView<S>).() -> Unit)? = null
): TreeTableView<S> = javafxx.layouts.styledTreeTableView(styleClass, root, init)()

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
interface TreeTableColumnsBuilder<S> {

    fun <T> column(
        text: String? = null,
        init: (TreeTableColumn<S, T>.() -> Unit)? = null
    ): TreeTableColumn<S, T>

    operator fun <T> String.invoke(
        init: (TreeTableColumn<S, T>.() -> Unit)? = null
    ): TreeTableColumn<S, T> = column(this, init)
}

/** Invokes a [TreeTableColumn] DSL builder. */
inline fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _TreeTableColumnsBuilder<S>().apply(init).childs
}