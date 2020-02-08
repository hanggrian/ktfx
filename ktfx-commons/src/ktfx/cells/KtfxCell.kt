package ktfx.cells

/** Defines a lifecycle of custom cell/row. */
internal interface KtfxCell<out T> {

    /** Called when cell is on editing mode. */
    fun onEditStart(action: () -> Unit)

    /** Called when cell edit is being committed. */
    fun onEditCommit(action: (T?) -> Unit)

    /** Called when cell edit is canceled. */
    fun onEditCancel(action: () -> Unit)

    /** Called when cell item is updating. */
    fun onUpdate(action: (T?, empty: Boolean) -> Unit)
}
