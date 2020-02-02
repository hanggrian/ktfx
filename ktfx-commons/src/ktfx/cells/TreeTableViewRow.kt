package ktfx.cells

import javafx.scene.control.TreeTableView

/** A function which produces a TreeTableRow. */
inline fun <S> TreeTableView<S>.rowFactory(
    crossinline rowFactory: TreeTableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { TreeTableRowBuilder<S>().apply(rowFactory) }
