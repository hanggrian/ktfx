@file:JvmMultifileClass
@file:JvmName("ColumnKt")
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
fun <S> TableView<S>.columns(builder: (@TableColumnDslMarker TableColumnsBuilder<S>.() -> Unit)): Unit =
    TableColumnsBuilder<S>(columns).builder()

/** Invokes a [TableColumn] DSL builder creating multiline column. */
fun <S, T> TableColumn<S, T>.columns(builder: (@TableColumnDslMarker TableColumnsBuilder<S>.() -> Unit)): Unit =
    TableColumnsBuilder<S>(columns).builder()

/** Interface to build [TableColumn] with Kotlin DSL. */
class TableColumnsBuilder<S> internal constructor(private val columns: MutableCollection<TableColumn<S, *>>) {

    fun <T> column(text: String? = null): TableColumn<S, T> =
        TableColumn<S, T>(text).also { columns += it }

    inline fun <T> column(
        text: String? = null,
        init: (@TableColumnDslMarker TableColumn<S, T>.() -> Unit)
    ): TableColumn<S, T> = column<T>(text).apply(init)

    inline operator fun <T> String.invoke(
        init: (@TableColumnDslMarker TableColumn<S, T>.() -> Unit)
    ): TableColumn<S, T> = column(this, init)
}
