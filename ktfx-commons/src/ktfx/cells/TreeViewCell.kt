package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CellUtils2
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ComboBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.util.StringConverter

/** Creates a [CheckBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView())

/** Creates a [CheckBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.checkBoxCellFactory(
    converter: StringConverter<TreeItem<T>> = CellUtils2.defaultTreeItemStringConverter(),
    callback: (TreeItem<T>) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeCell.forTreeView(callback, converter))

/** Creates a [ChoiceBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, *items))

/** Creates a [ChoiceBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, items))

/** Creates a [ComboBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxTreeCell.forTreeView(converter, *items))

/** Creates a [ComboBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTreeCell.forTreeView(converter, items))

/** Creates a [TextFieldTreeCell] factory for use in [TreeView] controls. */
fun TreeView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeCell.forTreeView())

/** Creates a [TextFieldTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.textFieldCellFactory(
    converter: StringConverter<T> = CellUtils2.defaultStringConverter()
): Unit = setCellFactory(TextFieldTreeCell.forTreeView(converter))
