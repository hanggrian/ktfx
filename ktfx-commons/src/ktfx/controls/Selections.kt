@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.beans.binding.BooleanBinding
import javafx.scene.control.MultipleSelectionModel
import javafx.scene.control.SelectionModel
import ktfx.bindings.isEmpty
import ktfx.bindings.isNotEmpty

/** Returns `true` if the model is selected. */
inline fun SelectionModel<*>.isSelected(): Boolean = selectedItem != null

/** Returns `true` if the model is not selected. */
inline fun SelectionModel<*>.isNotSelected(): Boolean = selectedItem == null

/** Returns `true` if the model is selected. */
inline fun MultipleSelectionModel<*>.isSelected(): Boolean = selectedItems.isNotEmpty()

/** Returns `true` if the model is not selected. */
inline fun MultipleSelectionModel<*>.isNotSelected(): Boolean = selectedItems.isEmpty()

/** Returns a boolean binding that holds `true` when item is selected. */
inline val SelectionModel<*>.selectedBinding: BooleanBinding get() = selectedItemProperty().isNotNull

/** Returns a boolean binding that holds `true` when item is not selected. */
inline val SelectionModel<*>.notSelectedBinding: BooleanBinding get() = selectedItemProperty().isNull

/** Returns a boolean binding that holds `true` when item is selected. */
inline val MultipleSelectionModel<*>.selectedBinding: BooleanBinding get() = selectedItems.isNotEmpty

/** Returns a boolean binding that holds `true` when item is not selected. */
inline val MultipleSelectionModel<*>.notSelectedBinding: BooleanBinding get() = selectedItems.isEmpty
