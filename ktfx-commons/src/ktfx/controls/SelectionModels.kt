@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.control.SelectionModel

/** Returns `true` if the model is selected. */
inline fun <T> SelectionModel<T>.isSelected(): Boolean =
    selectedItem != null

/** Returns `true` if the model is not selected. */
inline fun <T> SelectionModel<T>.isNotSelected(): Boolean =
    selectedItem == null
