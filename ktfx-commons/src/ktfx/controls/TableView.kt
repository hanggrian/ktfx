@file:UseExperimental(ExperimentalContracts::class)

package ktfx.controls

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Apply [TableView.CONSTRAINED_RESIZE_POLICY] to this [TableView]. */
@Suppress("NOTHING_TO_INLINE")
inline fun TableView<*>.constrained() {
    columnResizePolicy = TableView.CONSTRAINED_RESIZE_POLICY
}

/** Apply [TableView.UNCONSTRAINED_RESIZE_POLICY] to this [TableView]. */
@Suppress("NOTHING_TO_INLINE")
inline fun TableView<*>.unconstrained() {
    columnResizePolicy = TableView.UNCONSTRAINED_RESIZE_POLICY
}

/** Return columns configurator of this [TableView]. */
inline val <S> TableView<S>.tableColumns: TableColumnContainer<S> get() = TableColumnContainer(columns)

/** Configure columns of this [TableView] using [configuration] block. */
inline fun <S> TableView<S>.tableColumns(configuration: TableColumnContainerScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnContainerScope(columns).configuration()
}

/** Return columns configurator of this [TableColumn]. */
inline val <S> TableColumn<S, *>.tableColumns: TableColumnContainer<S> get() = TableColumnContainer(columns)

/** Configure columns of this [TableColumn] using [configuration] block. */
inline fun <S> TableColumn<S, *>.tableColumns(configuration: TableColumnContainer<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnContainerScope<S>(columns).configuration()
}

/** Container of [TableColumn], providing sets of useful operation. */
open class TableColumnContainer<S> @PublishedApi internal constructor(
    @PublishedApi internal val columns: MutableCollection<TableColumn<S, *>>
) {

    /** Add a default column using [text], returning the column added. */
    fun <T> column(text: String? = null): TableColumn<S, T> =
        TableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> column(
        text: String? = null,
        configuration: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> {
        val column = TableColumn<S, T>(text)
        column.configuration()
        columns += column
        return column
    }
}

/** Receiver for `tableColumns` block. */
@TableColumnDslMarker
class TableColumnContainerScope<S> @PublishedApi internal constructor(
    columns: MutableCollection<TableColumn<S, *>>
) : TableColumnContainer<S>(columns) {

    /** Add a column using receiver and [configuration] block, returning the column added. */
    inline operator fun <T> String.invoke(
        configuration: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = column(this, configuration)
}
