package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CellUtils2
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ComboBoxTableCell
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.util.StringConverter

/** Creates a [CheckBoxTableCell] factory for use in [TableColumn] controls. */
fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(this))

/** Creates a [CheckBoxTableCell] factory for use in [TableColumn] controls. */
fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, converter))

/** Creates a [CheckBoxTableCell] factory for use in [TableColumn] controls. */
fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, showLabel))

/** Creates a [ChoiceBoxTableCell] factory for use in [TableColumn] controls. */
fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, *items))

/** Creates a [ChoiceBoxTableCell] factory for use in [TableColumn] controls. */
fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, items))

/** Creates a [ComboBoxTableCell] factory for use in [TableColumn] controls. */
fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxTableCell.forTableColumn(converter, *items))

/** Creates a [ComboBoxTableCell] factory for use in [TableColumn] controls. */
fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTableCell.forTableColumn(converter, items))

/** Creates a [ProgressBarTableCell] factory for use in [TableColumn] controls. */
fun <S> TableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTableCell.forTableColumn<S>())

/** Creates a [TextFieldTableCell] factory for use in [TableColumn] controls. */
fun <S> TableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTableCell.forTableColumn())

/** Creates a [TextFieldTableCell] factory for use in [TableColumn] controls. */
fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter()
): Unit = setCellFactory(TextFieldTableCell.forTableColumn(converter))

/** Set custom cell factory to this [TableColumn]. */
fun <S, T> TableColumn<S, T>.cellFactory(
    cellFactory: TableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { TableCellBuilder<S, T>().apply(cellFactory) }
