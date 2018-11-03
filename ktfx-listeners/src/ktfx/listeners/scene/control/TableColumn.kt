@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.TextFieldTableCell

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, buildStringConverter(converter)))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), *items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), *items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), items))

inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(TextFieldTableCell.forTableColumn(buildStringConverter(converter)))

inline fun <S, T> TableColumn<S, T>.cellFactory(
    noinline cellFactory: TableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { cellFactory.build() }