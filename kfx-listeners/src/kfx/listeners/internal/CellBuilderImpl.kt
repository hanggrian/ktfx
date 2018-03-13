package kfx.listeners.internal

import kfx.listeners.CellBuilder

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