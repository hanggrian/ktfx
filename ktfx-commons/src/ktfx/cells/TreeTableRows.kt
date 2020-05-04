package ktfx.cells

import javafx.scene.control.TreeTableRow
import javafx.scene.control.TreeTableView

/**
 * Sets a custom row factory to use in this [TreeTableView].
 * @param S The type of the elements contained within the [TreeTableView].
 * @param configuration custom initialization block that configures [KtfxTreeTableRow].
 */
fun <S> TreeTableView<S>.rowFactory(
    configuration: KtfxTreeTableRow<S>.(TreeTableView<S>) -> Unit
): Unit = setRowFactory {
    val builder = KtfxTreeTableRow<S>()
    builder.configuration(it)
    builder
}

/** Custom [TreeTableRow] configurator class. */
class KtfxTreeTableRow<T> internal constructor() : TreeTableRow<T>(), KtfxCell<T> {
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
