@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package ktfx.listeners

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow

/** Interface to build [javafx.scene.control.Cell] with Kotlin DSL. */
interface CellBuilder<T> {

    /** Invoked when cell is on editing mode. */
    fun onEditStart(listener: () -> Unit)

    /** Calling `startEdit` super method. */
    fun editStart()

    /** Invoked when cell edit is being committed. */
    fun onEditCommit(listener: (T?) -> Unit)

    /** Calling `commitEdit` super method. */
    fun editCommit(newValue: T?)

    /** Invoked when cell edit is canceled. */
    fun onEditCancel(listener: () -> Unit)

    /** Calling `cancelEdit` super method. */
    fun editCancel()

    /** Invoked when cell item is updating. */
    fun onUpdate(listener: (T?, empty: Boolean) -> Unit)

    /** Calling `updateItem` super method. */
    fun update(item: T?, empty: Boolean)
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

    override fun editStart() = super.startEdit()

    override fun startEdit() {
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun editCommit(newValue: T?) = super.commitEdit(newValue)

    override fun commitEdit(newValue: T?) {
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun editCancel() = super.cancelEdit()

    override fun cancelEdit() {
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun update(item: T?, empty: Boolean) = super.updateItem(item, empty)

    override fun updateItem(item: T, empty: Boolean) {
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

    override fun editStart() = super.startEdit()

    override fun startEdit() {
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun editCommit(newValue: T?) = super.commitEdit(newValue)

    override fun commitEdit(newValue: T?) {
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun editCancel() = super.cancelEdit()

    override fun cancelEdit() {
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun update(item: T?, empty: Boolean) = super.updateItem(item, empty)

    override fun updateItem(item: T, empty: Boolean) {
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

    override fun editStart() = super.startEdit()

    override fun startEdit() {
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun editCommit(newValue: T?) = super.commitEdit(newValue)

    override fun commitEdit(newValue: T?) {
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun editCancel() = super.cancelEdit()

    override fun cancelEdit() {
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun update(item: T?, empty: Boolean) = super.updateItem(item, empty)

    override fun updateItem(item: T, empty: Boolean) {
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

    override fun editStart() = super.startEdit()

    override fun startEdit() {
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun editCommit(newValue: T?) = super.commitEdit(newValue)

    override fun commitEdit(newValue: T?) {
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun editCancel() = super.cancelEdit()

    override fun cancelEdit() {
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun update(item: T?, empty: Boolean) = super.updateItem(item, empty)

    override fun updateItem(item: T, empty: Boolean) {
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

    override fun editStart() = super.startEdit()

    override fun startEdit() {
        onEditStart?.invoke()
    }

    override fun onEditCommit(listener: (T?) -> Unit) {
        onEditCommit = listener
    }

    override fun editCommit(newValue: T?) = super.commitEdit(newValue)

    override fun commitEdit(newValue: T?) {
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(listener: () -> Unit) {
        onEditCancel = listener
    }

    override fun editCancel() = super.cancelEdit()

    override fun cancelEdit() {
        onEditCancel?.invoke()
    }

    override fun onUpdate(listener: (T?, empty: Boolean) -> Unit) {
        onUpdate = listener
    }

    override fun update(item: T?, empty: Boolean) = super.updateItem(item, empty)

    override fun updateItem(item: T, empty: Boolean) {
        onUpdate?.invoke(item, empty)
    }
}