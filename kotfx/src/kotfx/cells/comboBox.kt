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
import kotfx.internal.asConverter

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ComboBoxListCell.forListView(*items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ComboBoxListCell.forListView(converter.asConverter(), *items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ComboBoxListCell.forListView(items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ComboBoxListCell.forListView(converter.asConverter(), items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.asConverter(), *items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ChoiceBoxTableCell.forTableColumn(converter.asConverter(), items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(*items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.asConverter(), *items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeCell.forTreeView(converter.asConverter(), items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.asConverter(), *items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(ChoiceBoxTreeTableCell.forTreeTableColumn(converter.asConverter(), items))