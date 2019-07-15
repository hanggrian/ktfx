@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.listeners

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow

/** Interface to build [javafx.scene.control.Cell] with Kotlin DSL. */
interface CellBuilder<out T> {

    /** Invoked when cell is on editing mode. */
    fun onEditStart(listener: () -> Unit) // ktlint-disable

    /** Invoked when cell edit is being committed. */
    fun onEditCommit(listener: (T?) -> Unit) // ktlint-disable

    /** Invoked when cell edit is canceled. */
    fun onEditCancel(listener: () -> Unit) // ktlint-disable

    /** Invoked when cell item is updating. */
    fun onUpdate(listener: (T?, empty: Boolean) -> Unit) // ktlint-disable
}

/** [ListCell] builder with Kotlin DSL. */
class ListCellBuilder<T> : ListCell<T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(listener: () -> Unit) {
        onEditStart = listener
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TableRow] builder with Kotlin DSL. */
class TableRowBuilder<T> : TableRow<T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(listener: () -> Unit) {
        onEditStart = listener
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TableCell] builder with Kotlin DSL. */
class TableCellBuilder<S, T> : TableCell<S, T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(listener: () -> Unit) {
        onEditStart = listener
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TreeTableRow] builder with Kotlin DSL. */
class TreeTableRowBuilder<T> : TreeTableRow<T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(listener: () -> Unit) {
        onEditStart = listener
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TreeTableCell] builder with Kotlin DSL. */

class TreeTableCellBuilder<S, T> : TreeTableCell<S, T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(listener: () -> Unit) {
        onEditStart = listener
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

@PublishedApi
internal inline fun <T> (ListCellBuilder<T>.() -> Unit).build(): ListCell<T> =
    ListCellBuilder<T>().apply(this)

@PublishedApi
internal inline fun <T> (TableRowBuilder<T>.() -> Unit).build(): TableRow<T> =
    TableRowBuilder<T>().apply(this)

@PublishedApi
internal inline fun <S, T> (TableCellBuilder<S, T>.() -> Unit).build(): TableCell<S, T> =
    TableCellBuilder<S, T>().apply(this)

@PublishedApi
internal inline fun <T> (TreeTableRowBuilder<T>.() -> Unit).build(): TreeTableRow<T> =
    TreeTableRowBuilder<T>().apply(this)

@PublishedApi
internal inline fun <S, T> (TreeTableCellBuilder<S, T>.() -> Unit).build(): TreeTableCell<S, T> =
    TreeTableCellBuilder<S, T>().apply(this)
