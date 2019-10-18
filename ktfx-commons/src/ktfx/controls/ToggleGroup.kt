@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.scene.control.ToggleGroup

/** Returns `true` if toggle button is selected in this group. */
inline fun ToggleGroup.isSelected(): Boolean =
    selectedToggle != null

/** Returns `true` if toggle button is not selected in this group. */
inline fun ToggleGroup.isNotSelected(): Boolean =
    !isSelected()

/** Get selected toggle index. */
inline val ToggleGroup.selectedIndex: Int
    get() = toggles.indexOf(selectedToggle)

/** Select toggle by index. */
inline fun ToggleGroup.selectIndex(index: Int): Unit =
    selectToggle(toggles[index])
