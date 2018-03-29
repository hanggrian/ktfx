@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.scene.Node
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView

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

    fun <T> column(text: String? = null, init: TreeTableColumn<S, T>.() -> Unit): TreeTableColumn<S, T>
}

inline fun <T> TreeTableColumnsBuilder<*>.column(text: String? = null) = column<T>(text) { }

@PublishedApi
@Suppress("ClassName")
internal class _TreeTableColumnsBuilder<S> : TreeTableColumnsBuilder<S> {
    val columns: MutableList<TreeTableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: TreeTableColumn<S, T>.() -> Unit): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).apply(init).also { columns += it }
}

/** Invokes a [TreeTableColumn] DSL builder. */
inline fun <S> TreeTableView<S>.columns(init: TreeTableColumnsBuilder<S>.() -> Unit) {
    columns += _TreeTableColumnsBuilder<S>().apply(init).columns
}