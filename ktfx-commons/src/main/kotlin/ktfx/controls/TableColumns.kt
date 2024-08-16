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
public annotation class TableColumnDslMarker

/**
 * Configure [TableView] columns.
 *
 * @param configuration the configuration block.
 */
public inline fun <S> TableView<S>.columns(configuration: TableColumnScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnScope<S>(columns).configuration()
}

/**
 * Configure [TableColumn] columns, essentially enabling multi-line column.
 *
 * @param configuration the configuration block.
 */
public inline fun <S> TableColumn<S, *>.columns(configuration: TableColumnScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TableColumnScope<S>(columns).configuration()
}

/**
 * Configure [TreeTableView] columns.
 *
 * @param configuration the configuration block.
 */
public inline fun <S> TreeTableView<S>.columns(configuration: TreeTableColumnScope<S>.() -> Unit) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnScope<S>(columns).configuration()
}

/**
 * Configure [TreeTableColumn] columns, essentially enabling multi-line column.
 *
 * @param configuration the configuration block.
 */
public inline fun <S> TreeTableColumn<S, *>.columns(
    configuration: TreeTableColumnScope<S>.() -> Unit,
) {
    contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
    TreeTableColumnScope<S>(columns).configuration()
}

/**
 * [TableColumn] configurator interface.
 *
 * @property columns collection of columns within this scope.
 */
@TableColumnDslMarker
public class TableColumnScope<S>(public val columns: MutableCollection<TableColumn<S, *>>) {
    /** Add a default column using [text], returning the column added. */
    public fun <T> append(text: String? = null): TableColumn<S, T> =
        TableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    public inline fun <T> append(
        text: String? = null,
        configuration: TableColumn<S, T>.() -> Unit,
    ): TableColumn<S, T> {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return TableColumn<S, T>(text).also {
            it.configuration()
            columns += it
        }
    }

    /** Add a column using receiver and [configuration] block, returning the column added. */
    public inline operator fun <T> String.invoke(
        configuration: TableColumn<S, T>.() -> Unit,
    ): TableColumn<S, T> = append(this, configuration)
}

/**
 * [TreeTableColumn] configurator interface.
 *
 * @property columns collection of columns within this scope.
 */
@TableColumnDslMarker
public class TreeTableColumnScope<S>(public val columns: MutableCollection<TreeTableColumn<S, *>>) {
    /** Add a default column using [text], returning the column added. */
    public fun <T> append(text: String? = null): TreeTableColumn<S, T> =
        TreeTableColumn<S, T>(text).also { columns += it }

    /** Add a column using [text] and [configuration] block, returning the column added. */
    public inline fun <T> append(
        text: String? = null,
        configuration: TreeTableColumn<S, T>.() -> Unit,
    ): TreeTableColumn<S, T> {
        contract { callsInPlace(configuration, InvocationKind.EXACTLY_ONCE) }
        return TreeTableColumn<S, T>(text).also {
            it.configuration()
            columns += it
        }
    }

    /** Add a column using receiver and [configuration] block, returning the column added. */
    public inline operator fun <T> String.invoke(
        configuration: TreeTableColumn<S, T>.() -> Unit,
    ): TreeTableColumn<S, T> = append(this, configuration)
}
