@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.scene.control.cell.TextFieldListCell
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxListCell.forListView(callback))

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(CheckBoxListCell.forListView(callback, converter.asConverter()))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxListCell.forListView(converter.asConverter(), *items))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxListCell.forListView(converter.asConverter(), items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ComboBoxListCell.forListView(converter.asConverter(), *items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ComboBoxListCell.forListView(converter.asConverter(), items))

inline fun <T> ListView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldListCell.forListView(converter.asConverter()))

inline fun <T> ListView<T>.onEditCancel(noinline action: (ListView.EditEvent<T>) -> Unit) = setOnEditCancel(EventHandler(action))

inline fun <T> ListView<T>.onEditCommit(noinline action: (ListView.EditEvent<T>) -> Unit) = setOnEditCommit(EventHandler(action))

inline fun <T> ListView<T>.onEditStart(noinline action: (ListView.EditEvent<T>) -> Unit) = setOnEditStart(EventHandler(action))

inline fun ListView<*>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) = setOnScrollTo(EventHandler(action))