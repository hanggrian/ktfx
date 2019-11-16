package ktfx.cells

import javafx.scene.control.TreeTableView

/** A function which produces a TreeTableRow. */
fun <S> TreeTableView<S>.rowFactory(
    rowFactory: TreeTableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { TreeTableRowBuilder<S>().apply(rowFactory) }
