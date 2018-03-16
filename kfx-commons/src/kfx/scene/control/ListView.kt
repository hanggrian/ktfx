@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kfx.scene.control

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.TextFieldListCell

inline fun <T> ListView<T>.checkBoxCellFactory(noinline callback: (T) -> ObservableValue<Boolean>) =
    setCellFactory(CheckBoxListCell.forListView(callback))

inline fun <T> ListView<T>.choiceBoxCellFactory(vararg items: T) =
    setCellFactory(ChoiceBoxListCell.forListView(*items))

inline fun <T> ListView<T>.choiceBoxCellFactory(items: ObservableList<T>) =
    setCellFactory(ChoiceBoxListCell.forListView(items))

inline fun <T> ListView<T>.comboBoxCellFactory(vararg items: T) =
    setCellFactory(ComboBoxListCell.forListView(*items))

inline fun <T> ListView<T>.comboBoxCellFactory(items: ObservableList<T>) =
    setCellFactory(ComboBoxListCell.forListView(items))

inline fun ListView<String>.textFieldCellFactory() =
    setCellFactory(TextFieldListCell.forListView())