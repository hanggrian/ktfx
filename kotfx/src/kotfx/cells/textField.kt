@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.scene.control.ListView
import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.TextFieldListCell
import javafx.scene.control.cell.TextFieldTableCell
import javafx.scene.control.cell.TextFieldTreeCell
import javafx.scene.control.cell.TextFieldTreeTableCell
import javafx.util.StringConverter

inline fun ListView<String>.textFieldCellFactory() = setCellFactory(TextFieldListCell.forListView())

inline fun <T> ListView<T>.textFieldCellFactory(
    converter: StringConverter<T>
) = setCellFactory(TextFieldListCell.forListView(converter))

inline fun <S> TableColumn<S, String>.textFieldCellFactory() = setCellFactory(TextFieldTableCell.forTableColumn())

inline fun <S, T> TableColumn<S, T>.textFieldCellFactory(
    converter: StringConverter<T>
) = setCellFactory(TextFieldTableCell.forTableColumn(converter))

inline fun TreeView<String>.textFieldCellFactory() = setCellFactory(TextFieldTreeCell.forTreeView())

inline fun <T> TreeView<T>.textFieldCellFactory(
    converter: StringConverter<T>
) = setCellFactory(TextFieldTreeCell.forTreeView(converter))

inline fun <S> TreeTableColumn<S, String>.textFieldCellFactory() = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn())

inline fun <S, T> TreeTableColumn<S, T>.textFieldCellFactory(
    converter: StringConverter<T>
) = setCellFactory(TextFieldTreeTableCell.forTreeTableColumn(converter))