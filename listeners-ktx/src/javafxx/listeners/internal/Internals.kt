@file:Suppress("NOTHING_TO_INLINE")

package javafxx.listeners.internal

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow
import javafxx.listeners.ListCellBuilder
import javafxx.listeners.TableCellBuilder
import javafxx.listeners.TableRowBuilder
import javafxx.listeners.TreeTableCellBuilder
import javafxx.listeners.TreeTableRowBuilder

@PublishedApi
internal object Internals {

    inline fun <T> build(builder: ListCellBuilder<T>.() -> Unit): ListCell<T> =
        ListCellBuilder<T>().apply(builder)

    inline fun <T> build(builder: TableRowBuilder<T>.() -> Unit): TableRow<T> =
        TableRowBuilder<T>().apply(builder)

    inline fun <S, T> build(builder: TableCellBuilder<S, T>.() -> Unit): TableCell<S, T> =
        TableCellBuilder<S, T>().apply(builder)

    inline fun <T> build(builder: TreeTableRowBuilder<T>.() -> Unit): TreeTableRow<T> =
        TreeTableRowBuilder<T>().apply(builder)

    inline fun <S, T> build(builder: TreeTableCellBuilder<S, T>.() -> Unit): TreeTableCell<S, T> =
        TreeTableCellBuilder<S, T>().apply(builder)
}