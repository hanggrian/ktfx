@file:JvmMultifileClass
@file:JvmName("CellsKt")
@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx

import javafx.scene.control.TableColumn
import javafx.scene.control.TreeTableColumn
import javafx.scene.control.cell.ProgressBarTableCell
import javafx.scene.control.cell.ProgressBarTreeTableCell

inline fun <S> TableColumn<S, Double>.progressBarCellFactory() = setCellFactory(ProgressBarTableCell.forTableColumn<S>())

inline fun <S> TreeTableColumn<S, Double>.progressBarCellFactory() = setCellFactory(ProgressBarTreeTableCell.forTreeTableColumn<S>())