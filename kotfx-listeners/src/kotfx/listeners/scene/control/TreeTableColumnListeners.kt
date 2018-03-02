@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.scene.control.TreeTableCell
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import kotfx.listeners.internal.asConverter

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, showLabel))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, converter.asConverter()))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.asConverter(), *items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.asConverter(), items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.asConverter(), *items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.asConverter(), items))

inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter.asConverter()))

inline fun <S, T> TreeTableColumn<S, T>.onEditCancel(noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit) = setOnEditCancel(EventHandler(action))

inline fun <S, T> TreeTableColumn<S, T>.onEditCommit(noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit) = setOnEditCommit(EventHandler(action))

inline fun <S, T> TreeTableColumn<S, T>.onEditStart(noinline action: (TreeTableColumn.CellEditEvent<S, T>) -> Unit) = setOnEditStart(EventHandler(action))

inline fun <S, T> TreeTableColumn<S, T>.cellFactory(noinline callback: (TreeTableColumn<S, T>) -> TreeTableCell<S, T>) = setCellFactory(callback)