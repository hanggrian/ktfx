@file:Suppress("PackageDirectoryMismatch", "NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

/* ktlint-disable package-name */
package javafxx.listeners

/* ktlint-enable package-name */

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.TextFieldListCell

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(CheckBoxListCell.forListView(callback, stringConverter(converter)))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxListCell.forListView(stringConverter(converter), *items))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxListCell.forListView(stringConverter(converter), items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ComboBoxListCell.forListView(stringConverter(converter), *items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ComboBoxListCell.forListView(stringConverter(converter), items))

inline fun <T> ListView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldListCell.forListView(stringConverter(converter)))

inline fun <T> ListView<T>.cellFactory(
    noinline cellFactory: ListCellBuilder<T>.() -> Unit
) = setCellFactory { cellFactory.build() }