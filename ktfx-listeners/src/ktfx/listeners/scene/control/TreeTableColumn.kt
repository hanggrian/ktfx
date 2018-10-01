@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package ktfx.listeners

/* ktlint-enable package-name */

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, stringConverter(converter)))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(stringConverter(converter), *items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(stringConverter(converter), items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(stringConverter(converter), *items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(stringConverter(converter), items))

inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(stringConverter(converter)))

inline fun <S, T> TreeTableColumn<S, T>.cellFactory(
    noinline cellFactory: TreeTableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { cellFactory.build() }