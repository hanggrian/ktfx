package ktfx.cells

import javafx.scene.control.TableView

/** A function which produces a TableRow. */
inline fun <S> TableView<S>.rowFactory(
    crossinline rowFactory: TableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { TableRowBuilder<S>().apply(rowFactory) }
