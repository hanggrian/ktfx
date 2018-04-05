@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners.internal

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow
import ktfx.listeners.ListCellBuilder
import ktfx.listeners.TableCellBuilder
import ktfx.listeners.TableRowBuilder
import ktfx.listeners.TreeTableCellBuilder
import ktfx.listeners.TreeTableRowBuilder

/** Interface to build [javafx.scene.control.Cell] with Kotlin DSL. */
internal interface CellBuilder<out T> {

    /** Invoked when cell is on editing mode. */
    fun onEditStart(listener: () -> Unit)

    /** Invoked when cell edit is being committed. */
    fun onEditCommit(listener: (T?) -> Unit)

    /** Invoked when cell edit is canceled. */
    fun onEditCancel(listener: () -> Unit)

    /** Invoked when cell item is updating. */
    fun onUpdate(listener: (T?, empty: Boolean) -> Unit)
}

class CellBuilderImpl<T> : CellBuilder<T> {

    internal var onEditStart: (() -> Unit)? = null
    internal var onEditCommit: ((T?) -> Unit)? = null
    internal var onEditCancel: (() -> Unit)? = null
    internal var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(listener: () -> Unit) {
        onEditStart = listener
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }
}

@PublishedApi internal inline fun <T> (ListCellBuilder<T>.() -> Unit).build(): ListCell<T> =
    ListCellBuilder<T>().apply(this)

@PublishedApi internal inline fun <T> (TableRowBuilder<T>.() -> Unit).build(): TableRow<T> =
    TableRowBuilder<T>().apply(this)

@PublishedApi internal inline fun <S, T> (TableCellBuilder<S, T>.() -> Unit).build(): TableCell<S, T> =
    TableCellBuilder<S, T>().apply(this)

@PublishedApi internal inline fun <T> (TreeTableRowBuilder<T>.() -> Unit).build(): TreeTableRow<T> =
    TreeTableRowBuilder<T>().apply(this)

@PublishedApi internal inline fun <S, T> (TreeTableCellBuilder<S, T>.() -> Unit).build(): TreeTableCell<S, T> =
    TreeTableCellBuilder<S, T>().apply(this)