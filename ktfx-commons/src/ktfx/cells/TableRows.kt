package ktfx.cells

import javafx.scene.control.TableRow
import javafx.scene.control.TableView

/**
 * Sets a custom row factory to use in this [TableView].
 * @param S The type of the elements contained within the [TableView].
 * @param configuration custom initialization block that configures [KtfxTableRow].
 */
inline fun <S> TableView<S>.rowFactory(
    crossinline configuration: KtfxTableRow<S>.(TableView<S>) -> Unit
): Unit = setRowFactory {
    val builder = KtfxTableRow<S>()
    builder.configuration(it)
    builder
}

/** Custom [TableRow] configurator class. */
class KtfxTableRow<T> @PublishedApi internal constructor() : TableRow<T>(), KtfxCell<T> {
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
