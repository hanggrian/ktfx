@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell

fun <T> TreeView<T>.checkBoxCellFactory(
    callback: (TreeItem<T>) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<TreeItem<T>>.() -> Unit
): Unit = setCellFactory(CheckBoxTreeCell.forTreeView(callback, buildStringConverter(converter)))

fun <T> TreeView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(buildStringConverter(converter), *items))

fun <T> TreeView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(buildStringConverter(converter), items))

fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(buildStringConverter(converter), *items))

fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeCell.forTreeView(buildStringConverter(converter), items))

fun <T> TreeView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(TextFieldTreeCell.forTreeView(buildStringConverter(converter)))
