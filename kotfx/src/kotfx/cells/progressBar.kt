@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.ProgressBarTableCell.forTableColumn
import javafx.scene.control.cell.ProgressBarTreeTableCell.forTreeTableColumn

inline fun <S> TableColumn<S, Double>.progressBarCellFactory() = setCellFactory(forTableColumn<S>())

inline fun <S> TreeTableColumn<S, Double>.progressBarCellFactory() = setCellFactory(forTreeTableColumn<S>())