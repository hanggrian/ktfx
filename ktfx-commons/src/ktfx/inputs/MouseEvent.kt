@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent

/** Returns true if this is a one-click event. */
inline fun MouseEvent.isClicked(): Boolean =
    clickCount == 1

/** Returns true if this is a double-click event. */
inline fun MouseEvent.isDoubleClicked(): Boolean =
    clickCount == 2

/** Convenient method to check if mouse event is left click. */
inline fun MouseEvent.isLeftClick(): Boolean =
    isClicked() && button == MouseButton.PRIMARY

/** Convenient method to check if mouse event is right click. */
inline fun MouseEvent.isRightClick(): Boolean =
    isClicked() && button == MouseButton.SECONDARY

/** Convenient method to check if mouse event is middle click. */
inline fun MouseEvent.isMiddleClick(): Boolean =
    isClicked() && button == MouseButton.MIDDLE

/** Convenient method to check if mouse event is double left click. */
inline fun MouseEvent.isDoubleClick(): Boolean =
    isDoubleClicked() && button == MouseButton.PRIMARY
