@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kfx.listeners

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.TextFieldTableCell

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(CheckBoxTableCell.forTableColumn(callback, converter.build()))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.build(), *items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.build(), items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.build(), *items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.build(), items))

inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldTableCell.forTableColumn(converter.build()))

inline fun <S, T> TableColumn<S, T>.cellFactory(
    noinline cellFactory: TableCellBuilder<S, T>.() -> Unit
) = setCellFactory { cellFactory.build() }