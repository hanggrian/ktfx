package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ProgressBarTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell

fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(this))

fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(callback: (Int) -> ObservableValue<Boolean>): Unit =
    setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback))

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, showLabel))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

fun <S> TreeTableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn<S>())

fun <S> TreeTableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTreeTableCell.forTreeTableColumn())
