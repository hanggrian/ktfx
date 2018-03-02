@file:Suppress("NOTHING_TO_INLINE", "ClassName")

package kotfx.listeners

import javafx.scene.control.ListCell

class ListCellBuilder<T> : ListCell<T>() {
    private var onStartEdit: (() -> Unit)? = null
    private var onCommitEdit: ((T?) -> Unit)? = null
    private var onCancelEdit: (() -> Unit)? = null
    private var onUpdateItem: ((T?, empty: Boolean) -> Unit)? = null

    fun onStartEdit(listener: () -> Unit) {
        onStartEdit = listener
    }

    override fun startEdit() {
        super.startEdit()
        onStartEdit?.invoke()
    }

    fun onCommitEdit(listener: (T?) -> Unit) {
        onCommitEdit = listener
    }

    override fun commitEdit(newValue: T) {
        super.commitEdit(newValue)
        onCommitEdit?.invoke(newValue)
    }

    fun onCancelEdit(listener: () -> Unit) {
        onCancelEdit = listener
    }

    override fun cancelEdit() {
        super.cancelEdit()
        onCancelEdit?.invoke()
    }

    fun onUpdateItem(listener: (T?, empty: Boolean) -> Unit) {
        onUpdateItem = listener
    }

    override fun updateItem(item: T, empty: Boolean) {
        super.updateItem(item, empty)
        onUpdateItem?.invoke(item, empty)
    }
}

@PublishedApi internal inline fun <T> (ListCellBuilder<T>.() -> Unit).build(): ListCell<T> =
    ListCellBuilder<T>().apply(this)