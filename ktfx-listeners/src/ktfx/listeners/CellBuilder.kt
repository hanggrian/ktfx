@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.listeners

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow
import ktfx.listeners.internal.CellBuilder
import ktfx.listeners.internal.CellBuilderImpl

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