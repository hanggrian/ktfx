@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotlinfx.listeners

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, converter.build()))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.build(), *items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.build(), items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.build(), *items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.build(), items))

inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter.build()))

inline fun <S, T> TreeTableColumn<S, T>.cellFactory(
    noinline cellFactory: TreeTableCellBuilder<S, T>.() -> Unit
) = setCellFactory { cellFactory.build() }