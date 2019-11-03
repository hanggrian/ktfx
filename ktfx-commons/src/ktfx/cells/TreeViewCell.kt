package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CellUtils2
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.util.StringConverter
import javafx.util.converter.DefaultStringConverter

fun <T> TreeView<T>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView())

fun <T> TreeView<T>.checkBoxCellFactory(
    converter: StringConverter<TreeItem<T>> = CellUtils2.defaultTreeItemStringConverter(),
    callback: (TreeItem<T>) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeCell.forTreeView(callback, converter))

fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, *items))

fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, items))

fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, *items))

fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, items))

fun TreeView<String>.textFieldCellFactory(
    converter: StringConverter<String> = DefaultStringConverter()
): Unit = setCellFactory(TextFieldTreeCell.forTreeView(converter))
