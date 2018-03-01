@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control

import javafx.beans.value.ObservableValue
import javafx.collections.ObservableList
import javafx.event.EventHandler
import javafx.scene.control.ScrollToEvent
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.util.StringConverter
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTreeCell.forTreeView(callback))

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>,
    converter: StringConverter<TreeItem<T>>
) = setCellFactory(CheckBoxTreeCell.forTreeView(callback, converter))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.asConverter(), *items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.asConverter(), items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.asConverter(), *items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.asConverter(), items))

inline fun <T> TreeView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(TextFieldTreeCell.forTreeView(converter.asConverter()))

inline fun <T> TreeView<T>.onEditCancel(noinline action: (TreeView.EditEvent<T>) -> Unit) = setOnEditCancel(EventHandler(action))

inline fun <T> TreeView<T>.onEditCommit(noinline action: (TreeView.EditEvent<T>) -> Unit) = setOnEditCommit(EventHandler(action))

inline fun <T> TreeView<T>.onEditStart(noinline action: (TreeView.EditEvent<T>) -> Unit) = setOnEditStart(EventHandler(action))

inline fun TreeView<*>.onScrollTo(noinline action: (ScrollToEvent<Int>) -> Unit) = setOnScrollTo(EventHandler(action))