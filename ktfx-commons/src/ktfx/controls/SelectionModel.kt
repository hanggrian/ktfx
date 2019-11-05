@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.beans.binding.BooleanBinding
import javafx.scene.control.SelectionModel

/** Returns `true` if the model is selected. */
inline fun SelectionModel<*>.isSelected(): Boolean =
    selectedItem != null

/** Returns `true` if the model is not selected. */
inline fun SelectionModel<*>.isNotSelected(): Boolean =
    !isSelected()

/** Returns a boolean binding that holds `true` when item is selected. */
inline fun SelectionModel<*>.selectedProperty(): BooleanBinding =
    selectedItemProperty().isNotNull

/** Returns a boolean binding that holds `true` when item is not selected. */
inline fun SelectionModel<*>.notSelectedProperty(): BooleanBinding =
    selectedItemProperty().isNull
