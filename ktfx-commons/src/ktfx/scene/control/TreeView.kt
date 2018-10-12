@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.control

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell

inline fun <T> TreeView<T>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView())

inline fun <T> TreeView<T>.checkBoxCellFactory(noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView(callback))

inline fun <T> TreeView<T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

inline fun <T> TreeView<T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

inline fun <T> TreeView<T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

inline fun TreeView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeCell.forTreeView())