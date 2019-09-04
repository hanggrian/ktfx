package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.TextFieldListCell

fun <T> ListView<T>.checkBoxCellFactory(callback: (T) -> ObservableValue<Boolean>): Unit =
    setCellFactory(CheckBoxListCell.forListView(callback))

fun <T> ListView<T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxListCell.forListView(*items))

fun <T> ListView<T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxListCell.forListView(items))

fun <T> ListView<T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ComboBoxListCell.forListView(*items))

fun <T> ListView<T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ComboBoxListCell.forListView(items))

fun ListView<String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldListCell.forListView())
