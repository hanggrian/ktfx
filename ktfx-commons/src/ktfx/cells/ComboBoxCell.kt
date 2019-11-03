package ktfx.cells

import javafx.scene.control.ComboBox

/** Providing a custom cell factory allows for complete customization of the rendering of items in the ComboBox. */
fun <T> ComboBox<T>.cellFactory(
    cellFactory: ListCellBuilder<T>.() -> Unit
): Unit = setCellFactory { cellFactory.build() }
