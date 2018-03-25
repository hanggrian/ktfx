@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Effect
import javafx.scene.effect.Glow

/** The input for this [Effect]. */
inline operator fun Glow.component1(): Effect? = input

/** The level value, which controls the intensity of the glow effect. */
inline operator fun Glow.component2(): Double = level