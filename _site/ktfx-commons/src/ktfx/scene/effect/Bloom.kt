@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Bloom
import javafx.scene.effect.Effect

/** The input for this [Effect]. */
inline operator fun Bloom.component1(): Effect? = input

/** The threshold value controls the minimum luminosity value of the pixels that will be made to glow. */
inline operator fun Bloom.component2(): Double = threshold