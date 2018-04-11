@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.input

import javafx.scene.input.MouseButton.PRIMARY
import javafx.scene.input.MouseEvent

inline fun MouseEvent.isDoubleClick() = button == PRIMARY && clickCount == 2