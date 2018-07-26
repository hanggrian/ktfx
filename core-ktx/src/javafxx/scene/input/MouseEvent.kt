@file:Suppress("NOTHING_TO_INLINE")

package javafxx.scene.input

import javafx.scene.input.MouseButton.PRIMARY
import javafx.scene.input.MouseButton.SECONDARY
import javafx.scene.input.MouseEvent

inline fun MouseEvent.isLeftClick() = button == PRIMARY && clickCount == 1

inline fun MouseEvent.isRightClick() = button == SECONDARY && clickCount == 1

inline fun MouseEvent.isDoubleClick() = button == PRIMARY && clickCount == 2