@file:Suppress("NOTHING_TO_INLINE")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.KtfxCellUtils
import javafx.scene.control.cell.TextFieldListCell
import javafx.util.StringConverter

/** Creates a [CheckBoxListCell] factory for use in [ListView] controls. */
inline fun <T> ListView<T>.checkBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    crossinline selectedProperty: (T) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxListCell.forListView({ selectedProperty(it) }, converter))

/** Creates a [ChoiceBoxListCell] factory for use in [ListView] controls. */
inline fun <T> ListView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxListCell.forListView(converter, *items))

/** Creates a [ChoiceBoxListCell] factory for use in [ListView] controls. */
inline fun <T> ListView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxListCell.forListView(converter, items))

/** Creates a [ComboBoxListCell] factory for use in [ListView] controls. */
inline fun <T> ListView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxListCell.forListView(converter, *items))

/** Creates a [ComboBoxListCell] factory for use in [ListView] controls. */
inline fun <T> ListView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxListCell.forListView(converter, items))

/** Creates a [TextFieldListCell] factory for use in [ListView] controls. */
inline fun ListView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldListCell.forListView())

/** Creates a [TextFieldListCell] factory for use in [ListView] controls. */
inline fun <T> ListView<T>.textFieldCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter()
): Unit = setCellFactory(TextFieldListCell.forListView(converter))

/** Set custom cell factory to this [ListView]. */
inline fun <T> ListView<T>.cellFactory(
    crossinline builderAction: KtfxListCell<T>.(ListView<T>) -> Unit
): Unit = setCellFactory {
    val builder = KtfxListCell<T>()
    builder.builderAction(it)
    builder
}
