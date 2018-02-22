@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.ChoiceBoxTableCell
import javafx.scene.control.cell.ChoiceBoxTreeCell
import javafx.scene.control.cell.ChoiceBoxTreeTableCell
import javafx.scene.control.cell.ComboBoxListCell
import javafx.util.StringConverter

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ComboBoxListCell.forListView(*items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ComboBoxListCell.forListView(converter, *items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ComboBoxListCell.forListView(items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ComboBoxListCell.forListView(converter, items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, *items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter, items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, *items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter, items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, *items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: StringConverter<T>
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter, items))