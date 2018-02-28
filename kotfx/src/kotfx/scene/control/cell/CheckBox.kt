@file:JvmMultifileClass
@file:JvmName("CellsKt")
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
import javafx.scene.control.cell.CheckBoxTreeCell.forTreeView
import javafx.scene.control.cell.CheckBoxTreeTableCell.forTreeTableColumn
import javafx.util.StringConverter

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>
) = setCellFactory(forListView(callback))

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(forTableColumn(this))

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTableColumn(callback))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTableColumn(callback, showLabel))

inline fun <T> TreeView<T>.checkBoxCellFactory() = setCellFactory(forTreeView())

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>
) = setCellFactory(forTreeView(callback))

inline fun <T> TreeView<T>.checkBoxCellFactory(
    noinline callback: (TreeItem<T>) -> ObservableValue<Boolean>,
    converter: StringConverter<TreeItem<T>>
) = setCellFactory(forTreeView(callback, converter))

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(forTreeTableColumn(this))

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTreeTableColumn(callback))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    showLabel: Boolean,
    noinline callback: (Int) -> ObservableValue<Boolean>
) = setCellFactory(forTreeTableColumn(callback, showLabel))