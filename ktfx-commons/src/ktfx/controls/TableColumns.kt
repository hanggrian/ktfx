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

/**
 * Configure [TableView] columns.
 * @param configuration the configuration block.
 */
fun <S> TableView<S>.columns(configuration: TableColumnScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnScope(columns).configuration()
}

/**
 * Configure [TableColumn] columns, essentially enabling multi-line column.
 * @param configuration the configuration block.
 */
fun <S> TableColumn<S, *>.columns(configuration: TableColumnScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnScope<S>(columns).configuration()
}

/**
 * Configure [TreeTableView] columns.
 * @param configuration the configuration block.
 */
fun <S> TreeTableView<S>.columns(configuration: TreeTableColumnScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnScope<S>(columns).configuration()
}

/**
 * Configure [TreeTableColumn] columns, essentially enabling multi-line column.
 * @param configuration the configuration block.
 */
fun <S> TreeTableColumn<S, *>.columns(configuration: TreeTableColumnScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnScope<S>(columns).configuration()
}

/** Container of [TableColumn], providing sets of useful operation. */
@TableColumnDslMarker
class TableColumnScope<S> internal constructor(val columns: MutableCollection<TableColumn<S, *>>) {

    /** Add a default column using [text], returning the column added. */
    fun <T> append(text: String? = null): TableColumn<S, T> =
        TableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> append(
        text: String? = null,
        configuration: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> {
        val column = TableColumn<S, T>(text).apply(configuration)
        columns += column
        return column
    }

    /** Add a column using receiver and [configuration] block, returning the column added. */
    inline operator fun <T> String.invoke(
        configuration: TableColumn<S, T>.() -> Unit
    ): TableColumn<S, T> = append(this, configuration)
}

/** Container of [TreeTableColumn], providing sets of useful operation. */
@TableColumnDslMarker
class TreeTableColumnScope<S> internal constructor(val columns: MutableCollection<TreeTableColumn<S, *>>) {

    /** Add a default column using [text], returning the column added. */
    fun <T> append(text: String? = null): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    inline fun <T> append(
        text: String? = null,
        configuration: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> {
        val column = TreeTableColumn<S, T>(text).apply(configuration)
        columns += column
        return column
    }

    /** Add a column using receiver and [configuration] block, returning the column added. */
    inline operator fun <T> String.invoke(
        configuration: TreeTableColumn<S, T>.() -> Unit
    ): TreeTableColumn<S, T> = append(this, configuration)
}
