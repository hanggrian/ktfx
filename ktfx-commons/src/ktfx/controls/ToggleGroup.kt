@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.beans.binding.BooleanBinding
import javafx.scene.control.ToggleGroup

/** Returns `true` if toggle button is selected in this group. */
inline fun ToggleGroup.isSelected(): Boolean =
    selectedToggle != null

/** Returns `true` if toggle button is not selected in this group. */
inline fun ToggleGroup.isNotSelected(): Boolean =
    !isSelected()

/** Returns a boolean binding that holds `true` when item is selected. */
inline val ToggleGroup.selectedBinding: BooleanBinding
    get() = selectedToggleProperty().isNotNull

/** Returns a boolean binding that holds `true` when item is not selected. */
inline val ToggleGroup.notSelectedBinding: BooleanBinding
    get() = selectedToggleProperty().isNull

/** Get selected toggle index. */
inline val ToggleGroup.selectedIndex: Int
    get() = toggles.indexOf(selectedToggle)

/** Select toggle by index. */
inline fun ToggleGroup.selectIndex(index: Int): Unit =
    selectToggle(toggles[index])
