package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell

fun <T> TreeView<T>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView())

fun <T> TreeView<T>.checkBoxCellFactory(callback: (TreeItem<T>) -> ObservableValue<Boolean>): Unit =
    setCellFactory(CheckBoxTreeCell.forTreeView(callback))

fun <T> TreeView<T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

fun <T> TreeView<T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

fun <T> TreeView<T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

fun <T> TreeView<T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

fun TreeView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeCell.forTreeView())
