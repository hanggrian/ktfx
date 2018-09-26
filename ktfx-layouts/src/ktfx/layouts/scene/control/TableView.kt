@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

/* ktlint-disable package-name */
package ktfx.layouts

/* ktlint-enable package-name */

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import ktfx.collections.mutableObservableListOf

/** Creates a [TableView]. */
fun <S> tableView(
    items: ObservableList<S> = mutableObservableListOf(),
    init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).also {
    init?.invoke(it)
}

/** Creates a [TableView] and add it to this [LayoutManager]. */
inline fun <S> LayoutManager<Node>.tableView(
    items: ObservableList<S> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = ktfx.layouts.tableView(items, init)()

/** Create a styled [TableView]. */
fun <S> styledTableView(
    styleClass: String,
    items: ObservableList<S> = mutableObservableListOf(),
    init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = TableView<S>(items).also {
    it.styleClass += styleClass
    init?.invoke(it)
}

/** Creates a styled [TableView] and add it to this [LayoutManager]. */
inline fun <S> LayoutManager<Node>.styledTableView(
    styleClass: String,
    items: ObservableList<S> = mutableObservableListOf(),
    noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null
): TableView<S> = ktfx.layouts.styledTableView(styleClass, items, init)()

/** Interface to build [TableColumn] with Kotlin DSL. */
interface TableColumnsBuilder<S> {

    fun <T> column(
        text: String? = null,
        init: (TableColumn<S, T>.() -> Unit)? = null
    ): TableColumn<S, T>

    operator fun <T> String.invoke(
        init: (TableColumn<S, T>.() -> Unit)? = null
    ): TableColumn<S, T> = column(this, init)
}

/** Invokes a [TableColumn] DSL builder. */
inline fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).childs
}