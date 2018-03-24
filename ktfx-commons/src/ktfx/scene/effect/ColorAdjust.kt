@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.ColorAdjust
import javafx.scene.effect.Effect

/** The horizontal dimension of the blur effect. */
inline operator fun ColorAdjust.component1(): Effect? = input

/** The hue adjustment value. */
inline operator fun ColorAdjust.component2(): Double = hue

/** The saturation adjustment value. */
inline operator fun ColorAdjust.component3(): Double = saturation

/** The brightness adjustment value. */
inline operator fun ColorAdjust.component4(): Double = brightness

/** The contrast adjustment value. */
inline operator fun ColorAdjust.component5(): Double = contrast