package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ComboBoxTreeCell
import javafx.scene.control.cell.KtfxCellUtils
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.util.StringConverter

/** Creates a [CheckBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView())

/** Creates a [CheckBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.checkBoxCellFactory(
    converter: StringConverter<TreeItem<T>> = KtfxCellUtils.defaultTreeItemStringConverter(),
    callback: (TreeItem<T>) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeCell.forTreeView(callback, converter))

/** Creates a [ChoiceBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, *items))

/** Creates a [ChoiceBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.choiceBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, items))

/** Creates a [ComboBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    vararg items: T
): Unit = setCellFactory(ComboBoxTreeCell.forTreeView(converter, *items))

/** Creates a [ComboBoxTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.comboBoxCellFactory(
    converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter(),
    items: ObservableList<T>
): Unit = setCellFactory(ComboBoxTreeCell.forTreeView(converter, items))

/** Creates a [TextFieldTreeCell] factory for use in [TreeView] controls. */
fun TreeView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeCell.forTreeView())

/** Creates a [TextFieldTreeCell] factory for use in [TreeView] controls. */
fun <T> TreeView<T>.textFieldCellFactory(converter: StringConverter<T> = KtfxCellUtils.defaultStringConverter()): Unit =
    setCellFactory(TextFieldTreeCell.forTreeView(converter))
