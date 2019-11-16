package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.cell.CellUtils2
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.TextFieldListCell
import javafx.util.StringConverter

/** Creates a [CheckBoxListCell] factory for use in [ListView] controls. */
fun <T> ListView<T>.checkBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    selectedProperty: (T) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxListCell.forListView(selectedProperty, converter))

/** Creates a [ChoiceBoxListCell] factory for use in [ListView] controls. */
fun <T> ListView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxListCell.forListView(converter, *items))

/** Creates a [ChoiceBoxListCell] factory for use in [ListView] controls. */
fun <T> ListView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxListCell.forListView(converter, items))

/** Creates a [ComboBoxListCell] factory for use in [ListView] controls. */
fun <T> ListView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxListCell.forListView(converter, *items))

/** Creates a [ComboBoxListCell] factory for use in [ListView] controls. */
fun <T> ListView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxListCell.forListView(converter, items))

/** Creates a [TextFieldListCell] factory for use in [ListView] controls. */
fun ListView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldListCell.forListView())

/** Creates a [TextFieldListCell] factory for use in [ListView] controls. */
fun <T> ListView<T>.textFieldCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter()
): Unit = setCellFactory(TextFieldListCell.forListView(converter))

/** Set custom cell factory to this [ListView]. */
fun <T> ListView<T>.cellFactory(
    cellFactory: ListCellBuilder<T>.() -> Unit
): Unit = setCellFactory { ListCellBuilder<T>().apply(cellFactory) }
