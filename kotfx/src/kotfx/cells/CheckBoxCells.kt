@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.beans.value.ObservableValue
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeItem
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxListCell
import javafx.scene.control.cell.CheckBoxTableCell
import javafx.scene.control.cell.CheckBoxTreeCell
import javafx.scene.control.cell.CheckBoxTreeTableCell
import javafx.util.StringConverter

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxListCell.forListView(callback))

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>,
    converter: StringConverter<T>
) = setCellFactory(CheckBoxListCell.forListView(callback, converter))

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(CheckBoxTableCell.forTableColumn(this))

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTableCell.forTableColumn(callback))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    showLabel: Boolean
) = setCellFactory(CheckBoxTableCell.forTableColumn(callback, showLabel))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverter<T>
) = setCellFactory(CheckBoxTableCell.forTableColumn(callback, converter))

inline fun <T> TreeView<T>.checkBoxCellFactory() = setCellFactory(CheckBoxTreeCell.forTreeView())

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTreeCell.forTreeView(callback))

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>,
    converter: StringConverter<TreeItem<T>>
) = setCellFactory(CheckBoxTreeCell.forTreeView(callback, converter))

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(this))

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    showLabel: Boolean
) = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, showLabel))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: StringConverter<T>
) = setCellFactory(CheckBoxTreeTableCell.forTreeTableColumn(callback, converter))