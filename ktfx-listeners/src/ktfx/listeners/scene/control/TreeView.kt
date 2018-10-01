@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<TreeItem<T>>.() -> Unit
): Unit = setCellFactory(CheckBoxTreeCell.forTreeView(callback, stringConverter(converter)))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(stringConverter(converter), *items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(stringConverter(converter), items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(stringConverter(converter), *items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(stringConverter(converter), items))

inline fun <T> TreeView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(TextFieldTreeCell.forTreeView(stringConverter(converter)))