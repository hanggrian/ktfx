@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Effect
import javafx.scene.effect.GaussianBlur

/** The input for this [Effect]. */
inline operator fun GaussianBlur.component1(): Effect? = input

/** The radius of the blur kernel. */
inline operator fun GaussianBlur.component2(): Double = radius