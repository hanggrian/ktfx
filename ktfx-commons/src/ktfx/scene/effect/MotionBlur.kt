@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Effect
import javafx.scene.effect.MotionBlur

/** The input for this [Effect]. */
inline operator fun MotionBlur.component1(): Effect? = input

/** The radius of the blur kernel. */
inline operator fun MotionBlur.component2(): Double = radius

/** The angle of the motion effect, in degrees. */
inline operator fun MotionBlur.component3(): Double = angle