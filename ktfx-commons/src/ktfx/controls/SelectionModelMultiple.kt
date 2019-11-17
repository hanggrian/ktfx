@file:JvmMultifileClass
@file:JvmName("SelectionModelKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.beans.binding.BooleanBinding
import javafx.scene.control.MultipleSelectionModel
import ktfx.collections.emptyBinding
import ktfx.collections.notEmptyBinding

/** Returns `true` if the model is selected. */
inline fun MultipleSelectionModel<*>.isSelected(): Boolean =
    selectedItems.isNotEmpty()

/** Returns `true` if the model is not selected. */
inline fun MultipleSelectionModel<*>.isNotSelected(): Boolean =
    selectedItems.isEmpty()

/** Returns a boolean binding that holds `true` when item is selected. */
inline val MultipleSelectionModel<*>.selectedBinding: BooleanBinding
    get() = selectedItems.notEmptyBinding

/** Returns a boolean binding that holds `true` when item is not selected. */
inline val MultipleSelectionModel<*>.notSelectedBinding: BooleanBinding
    get() = selectedItems.emptyBinding
