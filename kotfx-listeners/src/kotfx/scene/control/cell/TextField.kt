@file:JvmMultifileClass
@file:JvmName("CellListenersKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control.cell

import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.TextFieldListCell.forListView
import javafx.scene.control.cell.TextFieldTableCell.forTableColumn
import javafx.scene.control.cell.TextFieldTreeCell.forTreeView
import javafx.scene.control.cell.TextFieldTreeTableCell.forTreeTableColumn
import kotfx.internal.asConverter
import kotfx.util.StringConverterBuilder

inline fun <T> ListView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(forListView(converter.asConverter()))

inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(forTableColumn(converter.asConverter()))

inline fun <T> TreeView<T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(forTreeView(converter.asConverter()))

inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverterBuilder<T>.() -> Unit
) = setCellFactory(forTreeTableColumn(converter.asConverter()))