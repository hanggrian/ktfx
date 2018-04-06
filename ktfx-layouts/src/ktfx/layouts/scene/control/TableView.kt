@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import ktfx.collections.mutableObservableListOf
import ktfx.layouts.internal._TableColumnsBuilder

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

    fun <T> column(text: String? = null): TableColumn<S, T> = column(text) { }

    fun <T> column(text: String? = null, init: TableColumn<S, T>.() -> Unit): TableColumn<S, T>

    operator fun <T> String.invoke(): TableColumn<S, T> = invoke { }

    operator fun <T> String.invoke(init: TableColumn<S, T>.() -> Unit): TableColumn<S, T> = column(this, init)
}

/** Invokes a [TableColumn] DSL builder. */
inline fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).columns
}