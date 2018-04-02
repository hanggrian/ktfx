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
    fun onStartEdit(listener: () -> Unit)

    /** Invoked when cell edit is being committed. */
    fun onCommitEdit(listener: (T?) -> Unit)

    /** Invoked when cell edit is canceled. */
    fun onCancelEdit(listener: () -> Unit)

    /** Invoked when cell item is updating. */
    fun onUpdate(listener: (T?, empty: Boolean) -> Unit)

    /** Clear text and graphic of current cell. */
    fun clear()
}

class CellBuilderImpl<T> : CellBuilder<T> {

    internal var onStartEdit: (() -> Unit)? = null
    internal var onCommitEdit: ((T?) -> Unit)? = null
    internal var onCancelEdit: (() -> Unit)? = null
    internal var onUpdateItem: ((T?, empty: Boolean) -> Unit)? = null

    override fun onStartEdit(listener: () -> Unit) {
        onStartEdit = listener
    }

    override fun onCommitEdit(listener: (T?) -> Unit) {
        onCommitEdit = listener
    }

    override fun onCancelEdit(listener: () -> Unit) {
        onCancelEdit = listener
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdateItem = listener
    }

    override fun clear() {}
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