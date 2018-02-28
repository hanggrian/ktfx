@file:JvmMultifileClass
@file:JvmName("CellListenersKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.cell

import javafx.beans.value.ObservableValue
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.CheckBoxListCell.forListView
import javafx.scene.control.cell.CheckBoxTableCell.forTableColumn
import javafx.scene.control.cell.CheckBoxTreeTableCell.forTreeTableColumn
import kotfx.util._StringConverter
import kotfx.internal.asConverter

inline fun <T> ListView<T>.checkBoxCellFactory(
    noinline callback: (T) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forListView(callback, converter.asConverter()))

inline fun <S, T> TableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTableColumn(callback, converter.asConverter()))

inline fun <S, T> TreeTableColumn<S, T>.checkBoxCellFactory(
    noinline callback: (Int) -> ObservableValue<Boolean>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(callback, converter.asConverter()))