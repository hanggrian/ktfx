@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import ktfx.collections.mutableObservableListOf

inline fun <S> tableView(
    items: ObservableList<S> = mutableObservableListOf()
): TableView<S> = tableView(items) { }

inline fun <S> tableView(
    items: ObservableList<S> = mutableObservableListOf(),
    init: (@LayoutDsl TableView<S>).() -> Unit
): TableView<S> = TableView<S>(items).apply(init)

inline fun <S> LayoutManager<Node>.tableView(
    items: ObservableList<S> = mutableObservableListOf()
): TableView<S> = tableView(items) { }

inline fun <S> LayoutManager<Node>.tableView(
    items: ObservableList<S> = mutableObservableListOf(),
    init: (@LayoutDsl TableView<S>).() -> Unit
): TableView<S> = ktfx.layouts.tableView(items, init).add()

/** Interface to build [TableColumn] with Kotlin DSL. */
interface TableColumnsBuilder<S> {

    fun <T> column(text: String? = null, init: TableColumn<S, T>.() -> Unit): TableColumn<S, T>
}

inline fun <T> TableColumnsBuilder<*>.column(text: String? = null) = column<T>(text) { }

@PublishedApi
@Suppress("ClassName")
internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S> {
    val columns: MutableList<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: TableColumn<S, T>.() -> Unit): TableColumn<S, T> =
        TableColumn<S, T>(text).apply(init).also { columns += it }
}

/** Invokes a [TableColumn] DSL builder. */
inline fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).columns
}