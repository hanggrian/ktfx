@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import ktfx.layouts.internal._TreeTableColumnsBuilder

inline fun <S> treeTableView(
    root: TreeItem<S>? = null
): TreeTableView<S> = treeTableView(root) { }

inline fun <S> treeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDsl TreeTableView<S>).() -> Unit
): TreeTableView<S> = TreeTableView<S>(root).apply(init)

inline fun <S> LayoutManager<Node>.treeTableView(
    root: TreeItem<S>? = null
): TreeTableView<S> = treeTableView(root) { }

inline fun <S> LayoutManager<Node>.treeTableView(
    root: TreeItem<S>? = null,
    init: (@LayoutDsl TreeTableView<S>).() -> Unit
): TreeTableView<S> = ktfx.layouts.treeTableView(root, init).add()

/** Interface to build [TreeTableColumn] with Kotlin DSL. */
interface TreeTableColumnsBuilder<S> {

    fun <T> column(text: String? = null): TreeTableColumn<S, T> = column(text) { }

    fun <T> column(text: String? = null, init: TreeTableColumn<S, T>.() -> Unit): TreeTableColumn<S, T>

    operator fun <T> String.invoke(): TreeTableColumn<S, T> = invoke { }

    operator fun <T> String.invoke(init: TreeTableColumn<S, T>.() -> Unit): TreeTableColumn<S, T> = column(this, init)
}

/** Invokes a [TreeTableColumn] DSL builder. */
inline fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _TreeTableColumnsBuilder<S>().apply(init).columns
}