package ktfx.cells

import javafx.scene.control.ComboBox

/** Set custom cell factory to this [ComboBox]. */
inline fun <T> ComboBox<T>.cellFactory(
    crossinline cellFactory: ListCellBuilder<T>.() -> Unit
): Unit = setCellFactory { ListCellBuilder<T>().apply(cellFactory) }
