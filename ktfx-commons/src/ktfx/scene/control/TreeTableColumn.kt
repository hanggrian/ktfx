@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.control

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ProgressBarTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(this))

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(noinline callback: (Int) -> ObservableValue<Boolean>): Unit =
    setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, showLabel))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

inline fun <S> TreeTableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn<S>())

inline fun <S> TreeTableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeTableCell.forTreeTableColumn())