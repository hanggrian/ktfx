@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package ktfx.scene.control

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell

inline fun <T> TreeView<T>.checkBoxCellFactory() =
    setCellFactory(CheckBoxTreeCell.forTreeView())

inline fun <T> TreeView<T>.checkBoxCellFactory(noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>) =
    setCellFactory(CheckBoxTreeCell.forTreeView(callback))

inline fun <T> TreeView<T>.choiceBoxCellFactory(vararg items: T) =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(items: ObservableList<T>) =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

inline fun <T> TreeView<T>.comboBoxCellFactory(vararg items: T) =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

inline fun <T> TreeView<T>.comboBoxCellFactory(items: ObservableList<T>) =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

inline fun TreeView<String>.textFieldCellFactory() =
    setCellFactory(TextFieldTreeCell.forTreeView())