package ktfx.cells

import javafx.scene.control.ComboBox

/** Set custom cell factory to this [ComboBox]. */
fun <T> ComboBox<T>.cellFactory(
    cellFactory: ListCellBuilder<T>.() -> Unit
): Unit = setCellFactory { ListCellBuilder<T>().apply(cellFactory) }
