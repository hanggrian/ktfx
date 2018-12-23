@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyEvent

/** Tests whether this key combination matches the key combination in the given event. */
inline operator fun KeyCodeCombination.contains(event: KeyEvent): Boolean = match(event)