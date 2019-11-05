@file:JvmMultifileClass
@file:JvmName("ColumnsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView

/** Apply [TableView.CONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TableView<*>.constrained() {
    columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TableView.UNCONSTRAINED_RESIZE_POLICY] to this table. */
inline fun TableView<*>.unconstrained() {
    columnResizePolicy = TableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Invokes a [TableColumn] DSL builder. */
fun <S> TableView<S>.columns(init: TableColumnsBuilder<S>.() -> Unit) {
    columns += TableColumnsBuilder<S>().apply(init).collection
}

/** Interface to build [TableColumn] with Kotlin DSL. */
class TableColumnsBuilder<S> internal constructor() {
    internal val collection: MutableCollection<TableColumn<S, *>> = mutableListOf()

    fun <T> column(text: String? = null): TableColumn<S, T> =
        TableColumn<S, T>(text).also { collection += it }

    inline fun <T> column(text: String? = null, init: TableColumn<S, T>.() -> Unit): TableColumn<S, T> =
        column<T>(text).apply(init)

    inline operator fun <T> String.invoke(init: TableColumn<S, T>.() -> Unit): TableColumn<S, T> =
        column(this, init)
}
