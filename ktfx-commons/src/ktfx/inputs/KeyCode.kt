@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCode.BACK_SPACE
import javafx.scene.input.KeyCode.DELETE
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination.Modifier

/** Returns true if this key is delete or backspace. */
inline fun KeyCode.isDelete(): Boolean = this == DELETE || this == BACK_SPACE

/** Constructs a combination based on main key code and additional modifier. */
inline operator fun KeyCode.plus(modifier: Modifier): KeyCodeCombination = KeyCodeCombination(this, modifier)

/** Constructs a combination based on main key code and additional modifiers. */
inline operator fun KeyCode.plus(modifiers: Array<Modifier>): KeyCodeCombination = KeyCodeCombination(this, *modifiers)