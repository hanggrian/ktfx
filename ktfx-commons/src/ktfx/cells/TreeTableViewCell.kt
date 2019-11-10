package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeTableView
import javafx.scene.control.cell.CellUtils2
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ComboBoxTreeTableCell
import javafx.scene.control.cell.ProgressBarTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import javafx.util.StringConverter

fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(this))

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, converter))

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, showLabel))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, *items))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, items))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(converter, *items))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTreeTableCell.forTreeTableColumn(converter, items))

fun <S> TreeTableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn<S>())

fun <S> TreeTableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeTableCell.forTreeTableColumn())

fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter()
): Unit = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter))

/** Set custom cell factory to this [TreeTableColumn]. */
fun <S, T> TreeTableColumn<S, T>.cellFactory(
    cellFactory: TreeTableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { TreeTableCellBuilder<S, T>().apply(cellFactory) }

/** A function which produces a TreeTableRow. */
fun <S> TreeTableView<S>.rowFactory(
    rowFactory: TreeTableRowBuilder<S>.() -> Unit
): Unit = setRowFactory { TreeTableRowBuilder<S>().apply(rowFactory) }
