@file:Suppress("NOTHING_TO_INLINE")

package ktfx.cells

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(this))

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(noinline callback: (Int) -> ObservableValue<Boolean>): Unit =
    setCellFactory(CheckBoxTableCell.forTableColumn(callback))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, showLabel))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(vararg items: T): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(items: ObservableList<T>): Unit =
    setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

inline fun <S> TableColumn<S, Double>.progressBarCellFactory(): Unit =
    setCellFactory(ProgressBarTableCell.forTableColumn<S>())

inline fun <S> TableColumn<S, String>.textFieldCellFactory(): Unit =
    setCellFactory(TextFieldTableCell.forTableColumn())