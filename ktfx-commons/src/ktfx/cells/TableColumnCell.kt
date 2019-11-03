package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CellUtils2
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.util.StringConverter
import javafx.util.converter.DefaultStringConverter

fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(this))

fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(
    converter: StringConverter<Boolean> = CellUtils2.defaultStringConverter(),
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, converter))

fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, showLabel))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, *items))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, items))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, *items))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, items))

fun <S> TableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTableCell.forTableColumn<S>())

fun <S> TableColumn<S, String>.textFieldCellFactory(
    converter: StringConverter<String> = DefaultStringConverter()
): Unit = setCellFactory(TextFieldTableCell.forTableColumn(converter))

fun <S, T> TableColumn<S, T>.cellFactory(
    cellFactory: TableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { cellFactory.build() }
