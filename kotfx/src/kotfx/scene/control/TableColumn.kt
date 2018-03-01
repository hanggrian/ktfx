@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.TextFieldTableCell

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(CheckBoxTableCell.forTableColumn(this))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(vararg items: T) = setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>) = setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(vararg items: T) = setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(items: ObservableList<T>) = setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

inline fun <S> TableColumn<S, Double>.progressBarCellFactory() = setCellFactory(ProgressBarTableCell.forTableColumn<S>())

inline fun <S> TableColumn<S, String>.textFieldCellFactory() = setCellFactory(TextFieldTableCell.forTableColumn())