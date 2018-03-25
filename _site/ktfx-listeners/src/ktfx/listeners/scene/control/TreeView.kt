@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.listeners

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
) = setCellFactory(CheckBoxTreeCell.forTreeView(callback, converter.build()))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.build(), *items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.build(), items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.build(), *items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.build(), items))

inline fun <T> TreeView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldTreeCell.forTreeView(converter.build()))