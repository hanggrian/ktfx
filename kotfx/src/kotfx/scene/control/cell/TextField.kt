@file:JvmMultifileClass
@file:JvmName("CellsKt")
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

inline fun ListView<String>.textFieldCellFactory() = setCellFactory(forListView())

inline fun <S> TableColumn<S, String>.textFieldCellFactory() = setCellFactory(forTableColumn())

inline fun TreeView<String>.textFieldCellFactory() = setCellFactory(forTreeView())

inline fun <S> TreeTableColumn<S, String>.textFieldCellFactory() = setCellFactory(forTreeTableColumn())