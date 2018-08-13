@file:Suppress("NOTHING_TO_INLINE")

package javafxx.scene.input

import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent

/** Convenient method to check if mouse event is left click. */
inline fun MouseEvent.isLeftClick() = button == MouseButton.PRIMARY && clickCount == 1

/** Convenient method to check if mouse event is right click. */
inline fun MouseEvent.isRightClick() = button == MouseButton.SECONDARY && clickCount == 1

/** Convenient method to check if mouse event is middle click. */
inline fun MouseEvent.isMiddleClick() = button == MouseButton.MIDDLE && clickCount == 1

/** Convenient method to check if mouse event is double left click. */
inline fun MouseEvent.isDoubleClick() = button == MouseButton.PRIMARY && clickCount == 2