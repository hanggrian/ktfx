@file:JvmMultifileClass
@file:JvmName("CellListenersKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.cell

import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.TextFieldListCell.forListView
import javafx.scene.control.cell.TextFieldTableCell.forTableColumn
import javafx.scene.control.cell.TextFieldTreeCell.forTreeView
import javafx.scene.control.cell.TextFieldTreeTableCell.forTreeTableColumn
import kotfx.util._StringConverter
import kotfx.internal.asConverter

inline fun <T> ListView<T>.textFieldCellFactory(
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forListView(converter.asConverter()))

inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTableColumn(converter.asConverter()))

inline fun <T> TreeView<T>.textFieldCellFactory(
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeView(converter.asConverter()))

inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: _StringConverter<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(converter.asConverter()))