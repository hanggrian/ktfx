@file:Suppress("NOTHING_TO_INLINE")

package ktfx.inputs

import javafx.scene.input.KeyCharacterCombination
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyCodeCombination
import javafx.scene.input.KeyCombination

/** Constructs a combination based on modifier and main character. */
operator fun KeyCombination.Modifier.plus(character: String): KeyCharacterCombination =
    KeyCharacterCombination(character, this)

/** Constructs a combination based on modifier and main code. */
operator fun KeyCombination.Modifier.plus(code: KeyCode): KeyCodeCombination = KeyCodeCombination(code, this)

/** Constructs a combination based on modifier and main code. */
inline operator fun KeyCode.plus(modifier: KeyCombination.Modifier): KeyCodeCombination = modifier + this
