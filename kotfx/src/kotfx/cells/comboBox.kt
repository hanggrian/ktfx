@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.ChoiceBoxTableCell.forTableColumn
import javafx.scene.control.cell.ChoiceBoxTreeCell.forTreeView
import javafx.scene.control.cell.ChoiceBoxTreeTableCell.forTreeTableColumn
import javafx.scene.control.cell.ComboBoxListCell.forListView
import kotfx.internal.asConverter

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(forListView(*items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forListView(converter.asConverter(), *items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(forListView(items))

inline fun <T> ListView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forListView(converter.asConverter(), items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(forTableColumn(*items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTableColumn(converter.asConverter(), *items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(forTableColumn(items))

inline fun <S, T> TableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTableColumn(converter.asConverter(), items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(forTreeView(*items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeView(converter.asConverter(), *items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(forTreeView(items))

inline fun <T> TreeView<T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeView(converter.asConverter(), items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T
) = setCellFactory(forTreeTableColumn(*items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(converter.asConverter(), *items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>
) = setCellFactory(forTreeTableColumn(items))

inline fun <S, T> TreeTableColumn<S, T>.comboBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(converter.asConverter(), items))