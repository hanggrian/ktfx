@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kfx.listeners

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow
import kfx.listeners.internal.CellBuilderImpl

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

/** [ListCell] builder with Kotlin DSL. */
class ListCellBuilder<T>(
    private val impl: CellBuilderImpl<T> = CellBuilderImpl()
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

    override fun clear() {
        text = null
        graphic = null
    }
}

@PublishedApi internal inline fun <T> (ListCellBuilder<T>.() -> Unit).build(): ListCell<T> =
    ListCellBuilder<T>().apply(this)

/** [TableRow] builder with Kotlin DSL. */
class TableRowBuilder<T>(
    private val impl: CellBuilderImpl<T> = CellBuilderImpl()
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

    override fun clear() {
        text = null
        graphic = null
    }
}

@PublishedApi internal inline fun <T> (TableRowBuilder<T>.() -> Unit).build(): TableRow<T> =
    TableRowBuilder<T>().apply(this)

/** [TableCell] builder with Kotlin DSL. */
class TableCellBuilder<S, T>(
    private val impl: CellBuilderImpl<T> = CellBuilderImpl()
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

    override fun clear() {
        text = null
        graphic = null
    }
}

@PublishedApi internal inline fun <S, T> (TableCellBuilder<S, T>.() -> Unit).build(): TableCell<S, T> =
    TableCellBuilder<S, T>().apply(this)

/** [TreeTableRow] builder with Kotlin DSL. */
class TreeTableRowBuilder<T>(
    private val impl: CellBuilderImpl<T> = CellBuilderImpl()
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

    override fun clear() {
        text = null
        graphic = null
    }
}

@PublishedApi internal inline fun <T> (TreeTableRowBuilder<T>.() -> Unit).build(): TreeTableRow<T> =
    TreeTableRowBuilder<T>().apply(this)

/** [TreeTableCell] builder with Kotlin DSL. */
class TreeTableCellBuilder<S, T>(
    private val impl: CellBuilderImpl<T> = CellBuilderImpl()
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

    override fun clear() {
        text = null
        graphic = null
    }
}

@PublishedApi internal inline fun <S, T> (TreeTableCellBuilder<S, T>.() -> Unit).build(): TreeTableCell<S, T> =
    TreeTableCellBuilder<S, T>().apply(this)