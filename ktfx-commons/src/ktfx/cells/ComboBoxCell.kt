package ktfx.cells

import javafx.scene.control.ComboBox
import javafx.scene.control.ListView

/** Set custom cell factory to this [ComboBox]. */
inline fun <T> ComboBox<T>.cellFactory(
    crossinline builderAction: KtfxListCell<T>.(ListView<T>) -> Unit
): Unit = setCellFactory {
    val builder = KtfxListCell<T>()
    builder.builderAction(it)
    builder
}
