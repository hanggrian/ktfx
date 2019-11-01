@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("PackageDirectoryMismatch")

package ktfx.listeners

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.TextFieldTreeTableCell

fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, buildStringConverter(converter)))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(buildStringConverter(converter), *items))

fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(buildStringConverter(converter), items))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(buildStringConverter(converter), *items))

fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(buildStringConverter(converter), items))

fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
): Unit = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(buildStringConverter(converter)))

fun <S, T> TreeTableColumn<S, T>.cellFactory(
    cellFactory: TreeTableCellBuilder<S, T>.() -> Unit
): Unit = setCellFactory { cellFactory.build() }
