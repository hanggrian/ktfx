@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ProgressBarTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(this))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(vararg items: T) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(vararg items: T) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(items: ObservableList<T>) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

inline fun <S> TreeTableColumn<S, Double>.progressBarCellFactory() = setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn<S>())

inline fun <S> TreeTableColumn<S, String>.textFieldCellFactory() = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn())