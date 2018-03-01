@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control.cell

import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.TreeView
import javafx.scene.control.cell.CheckBoxTableCell.forTableColumn
import javafx.scene.control.cell.CheckBoxTreeCell.forTreeView
import javafx.scene.control.cell.CheckBoxTreeTableCell.forTreeTableColumn

inline fun <S> TableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(forTableColumn(this))

inline fun <T> TreeView<T>.checkBoxCellFactory() = setCellFactory(forTreeView())

inline fun <S> TreeTableColumn<S, Boolean>.checkBoxCellFactory() = setCellFactory(forTreeTableColumn(this))