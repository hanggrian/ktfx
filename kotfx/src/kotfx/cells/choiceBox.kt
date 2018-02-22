@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.ChoiceBoxListCell
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.util.StringConverter

inline fun <T> ListView<T>.choiceBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxListCell.forListView(*items))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxListCell.forListView(converter, *items))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxListCell.forListView(items))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxListCell.forListView(converter, items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, *items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, *items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, *items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, items))