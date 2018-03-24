@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Effect
import javafx.scene.effect.SepiaTone

/** The input for this [Effect]. */
inline operator fun SepiaTone.component1(): Effect? = input

/** The level value, which controls the intensity of the sepia effect. */
inline operator fun SepiaTone.component2(): Double = level