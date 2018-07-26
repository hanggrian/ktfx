@file:Suppress("NOTHING_TO_INLINE")

package javafxx.scene.input

import javafx.scene.input.KeyCombination
import javafx.scene.input.KeyEvent

/** Tests whether this key combination matches the key combination in the given event. */
inline operator fun KeyCombination.contains(event: KeyEvent): Boolean = match(event)