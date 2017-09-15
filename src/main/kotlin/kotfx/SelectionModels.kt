@file:JvmName("SelectionModelsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx

import javafx.scene.control.SelectionModel

/** Checks whether or not this selection model is selected. */
inline val <T> SelectionModel<T>.isSelected: Boolean get() = selectedIndex >= 0

/** Checks whether or not this selection model is not selected. */
inline val <T> SelectionModel<T>.isNotSelected: Boolean get() = selectedIndex < 0