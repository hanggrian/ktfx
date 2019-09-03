@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.KeyCharacterCombination
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination
import javafx.scene.input.KeyEvent

/** Returns true if this key is delete or backspace. */
inline fun KeyCode.isDelete(): Boolean =
    this == KeyCode.DELETE || this == KeyCode.BACK_SPACE

/** Tests whether this key combination matches the key combination in the given event. */
inline operator fun KeyCharacterCombination.contains(event: KeyEvent): Boolean =
    match(event)

/** Constructs a combination based on main key code and additional modifier. */
inline operator fun KeyCode.plus(modifier: KeyCombination.Modifier): KeyCodeCombination =
    KeyCodeCombination(this, modifier)

/** Constructs a combination based on main key code and additional modifier. */
inline operator fun KeyCombination.Modifier.plus(code: KeyCode): KeyCodeCombination =
    code + this

/** Constructs a combination based on main key code and additional modifiers. */
inline operator fun KeyCode.plus(modifiers: Array<KeyCombination.Modifier>): KeyCodeCombination =
    KeyCodeCombination(this, *modifiers)

/** Constructs a combination based on main key code and additional modifiers. */
inline operator fun Array<KeyCombination.Modifier>.plus(code: KeyCode): KeyCodeCombination =
    code + this

/** Tests whether this key combination matches the key combination in the given event. */
inline operator fun KeyCodeCombination.contains(event: KeyEvent): Boolean =
    match(event)

/** Tests whether this key combination matches the key combination in the given event. */
inline operator fun KeyCombination.contains(event: KeyEvent): Boolean =
    match(event)
