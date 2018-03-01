@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.event.Event
import javafx.event.EventHandler
import javafx.event.EventType
import javafx.scene.control.TableColumn
import javafx.scene.control.TableColumnBase
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.TextFieldTableCell
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTableCell.forTableColumn(callback))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(CheckBoxTableCell.forTableColumn(callback, converter.asConverter()))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTableCell.forTableColumn(callback, showLabel))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.asConverter(), *items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.asConverter(), items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.asConverter(), *items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.asConverter(), items))

inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldTableCell.forTableColumn(converter.asConverter()))

inline fun <E : Event> TableColumnBase<*, *>.eventHandler(
    type: EventType<E>,
    noinline action: (E) -> Unit
) = addEventHandler(type, EventHandler(action))

inline fun <S, T> TableColumn<S, T>.onEditCancel(noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit) = setOnEditCancel(EventHandler(action))

inline fun <S, T> TableColumn<S, T>.onEditCommit(noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit) = setOnEditCommit(EventHandler(action))

inline fun <S, T> TableColumn<S, T>.onEditStart(noinline action: (TableColumn.CellEditEvent<S, T>) -> Unit) = setOnEditStart(EventHandler(action))