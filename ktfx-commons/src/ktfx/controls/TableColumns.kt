@file:OptIn(ExperimentalContracts::class)

package ktfx.controls

import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/** Delimits table column DSL configuration. */
@DslMarker
@Target(AnnotationTarget.CLASS)
annotation class TableColumnDslMarker

/** Return columns configurator of this [TableView]. */
inline val <S> TableView<S>.columns2: TableColumnContainer<S> get() = TableColumnContainer(columns)

/** Configure columns of this [TableView] using [configuration] block. */
inline fun <S> TableView<S>.columns(configuration: TableColumnContainerScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnContainerScope(columns).configuration()
}

/** Return columns configurator of this [TableColumn]. */
inline val <S> TableColumn<S, *>.columns2: TableColumnContainer<S> get() = TableColumnContainer(columns)

/** Configure columns of this [TableColumn] using [configuration] block. */
inline fun <S> TableColumn<S, *>.columns(configuration: TableColumnContainer<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnContainerScope<S>(columns).configuration()
}

/** Return columns configurator of this [TreeTableView]. */
inline val <S> TreeTableView<S>.columns2: TreeTableColumnContainer<S> get() = TreeTableColumnContainer(columns)

/** Configure columns of this [TreeTableView] using [configuration] block. */
inline fun <S> TreeTableView<S>.columns(configuration: TreeTableColumnContainerScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnContainerScope<S>(columns).configuration()
}

/** Return columns configurator of this [TreeTableColumn]. */
inline val <S> TreeTableColumn<S, *>.columns2: TreeTableColumnContainer<S> get() = TreeTableColumnContainer(columns)

/** Configure columns of this [TreeTableColumn] using [configuration] block. */
inline fun <S> TreeTableColumn<S, *>.columns(configuration: TreeTableColumnContainerScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnContainerScope<S>(columns).configuration()
}

/** Container of [TableColumn], providing sets of useful operation. */
open class TableColumnContainer<S> @PublishedApi internal constructor(
    @PublishedApi internal val columns: MutableCollection<TableColumn<S, *>>
) {

    /** Add a default column using [text], returning the column added. */
    fun <T> append(text: String? = null): TableColumn<S, T> =
        TableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> append(
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
    ): TableColumn<S, T> = append(this, configuration)
}

/** Container of [TreeTableColumn], providing sets of useful operation. */
open class TreeTableColumnContainer<S> @PublishedApi internal constructor(
    @PublishedApi internal val columns: MutableCollection<TreeTableColumn<S, *>>
) {

    /** Add a default column using [text], returning the column added. */
    fun <T> append(text: String? = null): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> append(
        text: String? = null,
        configuration: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> {
        val column = TreeTableColumn<S, T>(text)
        column.configuration()
        columns += column
        return column
    }
}

/** Receiver for `tableColumns` block. */
@TableColumnDslMarker
class TreeTableColumnContainerScope<S> @PublishedApi internal constructor(
    columns: MutableCollection<TreeTableColumn<S, *>>
) : TreeTableColumnContainer<S>(columns) {

    /** Add a column using receiver and [configuration] block, returning the column added. */
    inline operator fun <T> String.invoke(
        configuration: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = append(this, configuration)
}
