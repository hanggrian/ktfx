package ktfx.inputs

import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent

/** Convenient method to check if mouse event is left click. */
public fun MouseEvent.isLeftClick(): Boolean = button == MouseButton.PRIMARY && clickCount == 1

/** Convenient method to check if mouse event is right click. */
public fun MouseEvent.isRightClick(): Boolean = button == MouseButton.SECONDARY && clickCount == 1

/** Convenient method to check if mouse event is middle click. */
public fun MouseEvent.isMiddleClick(): Boolean = button == MouseButton.MIDDLE && clickCount == 1

/** Convenient method to check if mouse event is double click. */
public fun MouseEvent.isDoubleClick(): Boolean = button == MouseButton.PRIMARY && clickCount == 2
