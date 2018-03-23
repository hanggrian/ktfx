@file:Suppress("NOTHING_TO_INLINE")

package ktfx.layouts

import javafx.collections.ObservableList
import javafx.scene.Node
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import ktfx.collections.mutableObservableListOf

inline fun <S> tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null): TableView<S> = TableView<S>(items).apply { init?.invoke(this) }

inline fun <S> Manager<Node>.tableView(items: ObservableList<S> = mutableObservableListOf(), noinline init: ((@LayoutDsl TableView<S>).() -> Unit)? = null): TableView<S> = ktfx.layouts.tableView(items, init).add()

/** Interface to build [TableColumn] with Kotlin DSL. */
interface TableColumnsBuilder<S> {

    fun <T> column(text: String? = null, init: (TableColumn<S, T>.() -> Unit)? = null)
}

@PublishedApi
@Suppress("ClassName")
internal class _TableColumnsBuilder<S> : TableColumnsBuilder<S> {

    val columns: MutableList<TableColumn<S, *>> = mutableListOf()

    override fun <T> column(text: String?, init: (TableColumn<S, T>.() -> Unit)?) {
        columns += TableColumn<S, T>(text).apply { init?.invoke(this) }
    }
}

/** Invokes a [TableColumn] DSL builder. */
inline fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += _TableColumnsBuilder<S>().apply(init).columns
}