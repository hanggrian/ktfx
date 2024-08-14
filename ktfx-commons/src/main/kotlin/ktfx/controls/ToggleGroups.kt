@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.beans.binding.BooleanBinding
import javafx.scene.control.ToggleGroup

/** Returns `true` if toggle button is selected in this group. */
public inline fun ToggleGroup.isSelected(): Boolean = selectedToggle != null

/** Returns `true` if toggle button is not selected in this group. */
public inline fun ToggleGroup.isNotSelected(): Boolean = selectedToggle == null

/** Returns a boolean binding that holds `true` when item is selected. */
public inline val ToggleGroup.selectedBinding: BooleanBinding get() =
    selectedToggleProperty().isNotNull

/** Returns a boolean binding that holds `true` when item is not selected. */
public inline val ToggleGroup.notSelectedBinding: BooleanBinding get() =
    selectedToggleProperty().isNull

/** Get selected toggle index. */
public inline val ToggleGroup.selectedIndex: Int get() = toggles.indexOf(selectedToggle)

/** Select toggle by index. */
public inline fun ToggleGroup.selectIndex(index: Int): Unit = selectToggle(toggles[index])
