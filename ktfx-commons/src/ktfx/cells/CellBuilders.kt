package ktfx.cells

import javafx.scene.control.ListCell
import javafx.scene.control.TableCell
import javafx.scene.control.TableRow
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableRow

/** Interface to build [javafx.scene.control.Cell] with Kotlin DSL. */
interface CellBuilder<out T> {

    /** Invoked when cell is on editing mode. */
    fun onEditStart(action: () -> Unit)

    /** Invoked when cell edit is being committed. */
    fun onEditCommit(action: (T?) -> Unit)

    /** Invoked when cell edit is canceled. */
    fun onEditCancel(action: () -> Unit)

    /** Invoked when cell item is updating. */
    fun onUpdate(action: (T?, empty: Boolean) -> Unit)
}

/** [ListCell] builder with Kotlin DSL. */
class ListCellBuilder<T> @PublishedApi internal constructor() : ListCell<T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(action: () -> Unit) {
        onEditStart = action
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(action: (T?) -> Unit) {
        onEditCommit = action
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(action: () -> Unit) {
        onEditCancel = action
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(action: (T?, empty: Boolean) -> Unit) {
        onUpdate = action
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TableRow] builder with Kotlin DSL. */
class TableRowBuilder<T> @PublishedApi internal constructor() : TableRow<T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(action: () -> Unit) {
        onEditStart = action
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(action: (T?) -> Unit) {
        onEditCommit = action
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(action: () -> Unit) {
        onEditCancel = action
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(action: (T?, empty: Boolean) -> Unit) {
        onUpdate = action
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TableCell] builder with Kotlin DSL. */
class TableCellBuilder<S, T> @PublishedApi internal constructor() : TableCell<S, T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(action: () -> Unit) {
        onEditStart = action
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(action: (T?) -> Unit) {
        onEditCommit = action
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(action: () -> Unit) {
        onEditCancel = action
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(action: (T?, empty: Boolean) -> Unit) {
        onUpdate = action
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TreeTableRow] builder with Kotlin DSL. */
class TreeTableRowBuilder<T> @PublishedApi internal constructor() : TreeTableRow<T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(action: () -> Unit) {
        onEditStart = action
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(action: (T?) -> Unit) {
        onEditCommit = action
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(action: () -> Unit) {
        onEditCancel = action
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(action: (T?, empty: Boolean) -> Unit) {
        onUpdate = action
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}

/** [TreeTableCell] builder with Kotlin DSL. */
class TreeTableCellBuilder<S, T> @PublishedApi internal constructor() : TreeTableCell<S, T>(), CellBuilder<T> {
    private var onEditStart: (() -> Unit)? = null
    private var onEditCommit: ((T?) -> Unit)? = null
    private var onEditCancel: (() -> Unit)? = null
    private var onUpdate: ((T?, empty: Boolean) -> Unit)? = null

    override fun onEditStart(action: () -> Unit) {
        onEditStart = action
    }

    override fun startEdit() {
        super.startEdit()
        onEditStart?.invoke()
    }

    override fun onEditCommit(action: (T?) -> Unit) {
        onEditCommit = action
    }

    override fun commitEdit(newValue: T?) {
        super.commitEdit(newValue)
        onEditCommit?.invoke(newValue)
    }

    override fun onEditCancel(action: () -> Unit) {
        onEditCancel = action
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onEditCancel?.invoke()
    }

    override fun onUpdate(action: (T?, empty: Boolean) -> Unit) {
        onUpdate = action
    }

    override fun updateItem(item: T?, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdate?.invoke(item, empty)
    }
}
