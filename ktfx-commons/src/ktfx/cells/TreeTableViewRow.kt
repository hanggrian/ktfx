package ktfx.cells

import javafx.scene.control.TreeTableView

/** Set custom row factory to this [TreeTableView]. */
inline fun <S> TreeTableView<S>.rowFactory(
    crossinline builderAction: KtfxTreeTableRow<S>.(TreeTableView<S>) -> Unit
): Unit = setRowFactory {
    val builder = KtfxTreeTableRow<S>()
    builder.builderAction(it)
    builder
}
