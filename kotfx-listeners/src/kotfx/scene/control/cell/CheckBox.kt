@file:JvmMultifileClass
@file:JvmName("CellListenersKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control.cell

import javafx.beans.value.ObservableValue
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxListCell.forListView
import javafx.scene.control.cell.CheckBoxTableCell.forTableColumn
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.CheckBoxTreeTableCell.forTreeTableColumn
import javafx.util.StringConverter
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>
) = setCellFactory(forListView(callback))

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(forListView(callback, converter.asConverter()))

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTableColumn(callback))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(forTableColumn(callback, converter.asConverter()))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTableColumn(callback, showLabel))

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTreeCell.forTreeView(callback))

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>,
    converter: StringConverter<TreeItem<T>>
) = setCellFactory(CheckBoxTreeCell.forTreeView(callback, converter))

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTreeTableColumn(callback))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTreeTableColumn(callback, showLabel))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(callback, converter.asConverter()))
