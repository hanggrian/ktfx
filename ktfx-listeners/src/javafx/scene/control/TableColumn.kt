@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TableColumn
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.TextFieldTableCell

fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(CheckBoxTableCell.forTableColumn(callback, buildStringConverter(converter)))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), *items))

fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), items))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), *items))

fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTableCell.forTableColumn(buildStringConverter(converter), items))

fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(TextFieldTableCell.forTableColumn(buildStringConverter(converter)))

fun <S, T> TableColumn<S, T>.cellFactory(
    cellFactory: TableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { cellFactory.build() }
