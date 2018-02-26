@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.listeners

import javafx.collections.ObservableList
import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.ChoiceBoxListCell.forListView
import javafx.scene.control.cell.ChoiceBoxTableCell.forTableColumn
import javafx.scene.control.cell.ChoiceBoxTreeCell.forTreeView
import javafx.scene.control.cell.ChoiceBoxTreeTableCell.forTreeTableColumn
import kotfx.listeners.internal.asConverter

inline fun <T> ListView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forListView(converter.asConverter(), *items))

inline fun <T> ListView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forListView(converter.asConverter(), items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTableColumn(converter.asConverter(), *items))

inline fun <S, T> TableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTableColumn(converter.asConverter(), items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeView(converter.asConverter(), *items))

inline fun <T> TreeView<T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeView(converter.asConverter(), items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    vararg items: T,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(converter.asConverter(), *items))

inline fun <S, T> TreeTableColumn<S, T>.choiceBoxCellFactory(
    items: ObservableList<T>,
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(converter.asConverter(), items))