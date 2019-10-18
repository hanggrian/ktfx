package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell

fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(this))

fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(callback: (Int) -> ObservableValue<Boolean>): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(callback))

fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, showLabel))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

fun <S> TableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTableCell.forTableColumn<S>())

fun <S> TableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTableCell.forTableColumn())
