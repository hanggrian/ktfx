@file:JvmMultifileClass
@file:JvmName("KeyCombinationKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.KeyCharacterCombination
import javafx.scene.input.KeyCombination
import javafx.scene.input.KeyEvent

/** Tests whether this key combination matches the key combination in the given event. */
inline operator fun KeyEvent.contains(combination: KeyCharacterCombination): Boolean = combination.match(this)

/** Constructs a combination based on main key code and additional modifier. */
operator fun KeyCombination.Modifier.plus(character: String): KeyCharacterCombination =
    KeyCharacterCombination(character, this)
