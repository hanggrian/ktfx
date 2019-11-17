@file:JvmMultifileClass
@file:JvmName("SelectionModelKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.beans.binding.BooleanBinding
import javafx.scene.control.SelectionModel

/** Returns `true` if the model is selected. */
inline fun SelectionModel<*>.isSelected(): Boolean =
    selectedItem != null

/** Returns `true` if the model is not selected. */
inline fun SelectionModel<*>.isNotSelected(): Boolean =
    selectedItem == null

/** Returns a boolean binding that holds `true` when item is selected. */
inline val SelectionModel<*>.selectedBinding: BooleanBinding
    get() = selectedItemProperty().isNotNull

/** Returns a boolean binding that holds `true` when item is not selected. */
inline val SelectionModel<*>.notSelectedBinding: BooleanBinding
    get() = selectedItemProperty().isNull
