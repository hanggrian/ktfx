@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kfx.listeners

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow

private interface CellBuilder<out T> {

    fun onStartEdit(listener: () -> Unit)

    fun onCommitEdit(listener: (T?) -> Unit)

    fun onCancelEdit(listener: () -> Unit)

    fun onUpdateItem(listener: (T?, empty: Boolean) -> Unit)
}

class CellImpl<T> : CellBuilder<T> {
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

    override fun onUpdateItem(listener: (T?, empty: Boolean) -> Unit) {
        onUpdateItem = listener
    }
}

class ListCellBuilder<T>(
    private val impl: CellImpl<T> = CellImpl()
) : ListCell<T>(), CellBuilder<T> by impl {

    override fun startEdit() {
        super.startEdit()
        impl.onStartEdit?.invoke()
    }

    override fun commitEdit(newValue: T) {
        super.commitEdit(newValue)
        impl.onCommitEdit?.invoke(newValue)
    }

    override fun cancelEdit() {
        super.cancelEdit()
        impl.onCancelEdit?.invoke()
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)
        impl.onUpdateItem?.invoke(item, empty)
    }
}

@PublishedApi internal inline fun <T> (ListCellBuilder<T>.() -> Unit).build(): ListCell<T> =
    ListCellBuilder<T>().apply(this)

class TableRowBuilder<T>(
    private val impl: CellImpl<T> = CellImpl()
) : TableRow<T>(), CellBuilder<T> by impl {

    override fun startEdit() {
        super.startEdit()
        impl.onStartEdit?.invoke()
    }

    override fun commitEdit(newValue: T) {
        super.commitEdit(newValue)
        impl.onCommitEdit?.invoke(newValue)
    }

    override fun cancelEdit() {
        super.cancelEdit()
        impl.onCancelEdit?.invoke()
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)
        impl.onUpdateItem?.invoke(item, empty)
    }
}

@PublishedApi internal inline fun <T> (TableRowBuilder<T>.() -> Unit).build(): TableRow<T> =
    TableRowBuilder<T>().apply(this)

class TableCellBuilder<S, T>(
    private val impl: CellImpl<T> = CellImpl()
) : TableCell<S, T>(), CellBuilder<T> by impl {

    override fun startEdit() {
        super.startEdit()
        impl.onStartEdit?.invoke()
    }

    override fun commitEdit(newValue: T) {
        super.commitEdit(newValue)
        impl.onCommitEdit?.invoke(newValue)
    }

    override fun cancelEdit() {
        super.cancelEdit()
        impl.onCancelEdit?.invoke()
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)
        impl.onUpdateItem?.invoke(item, empty)
    }
}

@PublishedApi internal inline fun <S, T> (TableCellBuilder<S, T>.() -> Unit).build(): TableCell<S, T> =
    TableCellBuilder<S, T>().apply(this)

class TreeTableRowBuilder<T>(
    private val impl: CellImpl<T> = CellImpl()
) : TreeTableRow<T>(), CellBuilder<T> by impl {

    override fun startEdit() {
        super.startEdit()
        impl.onStartEdit?.invoke()
    }

    override fun commitEdit(newValue: T) {
        super.commitEdit(newValue)
        impl.onCommitEdit?.invoke(newValue)
    }

    override fun cancelEdit() {
        super.cancelEdit()
        impl.onCancelEdit?.invoke()
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)
        impl.onUpdateItem?.invoke(item, empty)
    }
}

@PublishedApi internal inline fun <T> (TreeTableRowBuilder<T>.() -> Unit).build(): TreeTableRow<T> =
    TreeTableRowBuilder<T>().apply(this)

class TreeTableCellBuilder<S, T>(
    private val impl: CellImpl<T> = CellImpl()
) : TreeTableCell<S, T>(), CellBuilder<T> by impl {

    override fun startEdit() {
        super.startEdit()
        impl.onStartEdit?.invoke()
    }

    override fun commitEdit(newValue: T) {
        super.commitEdit(newValue)
        impl.onCommitEdit?.invoke(newValue)
    }

    override fun cancelEdit() {
        super.cancelEdit()
        impl.onCancelEdit?.invoke()
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)
        impl.onUpdateItem?.invoke(item, empty)
    }
}

@PublishedApi internal inline fun <S, T> (TreeTableCellBuilder<S, T>.() -> Unit).build(): TreeTableCell<S, T> =
    TreeTableCellBuilder<S, T>().apply(this)