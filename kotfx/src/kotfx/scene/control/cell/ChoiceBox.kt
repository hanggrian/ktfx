@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control.cell

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.ChoiceBoxListCell.forListView
import javafx.scene.control.cell.ChoiceBoxTableCell.forTableColumn
import javafx.scene.control.cell.ChoiceBoxTreeCell.forTreeView
import javafx.scene.control.cell.ChoiceBoxTreeTableCell.forTreeTableColumn

inline fun <T> ListView<T>.choiceBoxCellFactory(vararg items: T) = setCellFactory(forListView(*items))

inline fun <T> ListView<T>.choiceBoxCellFactory(items: ObservableList<T>) = setCellFactory(forListView(items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(vararg items: T) = setCellFactory(forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>) = setCellFactory(forTableColumn(items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(vararg items: T) = setCellFactory(forTreeView(*items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(items: ObservableList<T>) = setCellFactory(forTreeView(items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(vararg items: T) = setCellFactory(forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(items: ObservableList<T>) = setCellFactory(forTreeTableColumn(items))