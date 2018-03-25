@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.BlurType
import javafx.scene.effect.Effect
import javafx.scene.effect.Shadow
import javafx.scene.paint.Color

/** The input for this [Effect]. */
inline operator fun Shadow.component1(): Effect? = input

/** The radius of the blur kernel. */
inline operator fun Shadow.component2(): Double = radius

/** The horizontal size of the shadow blur kernel. */
inline operator fun Shadow.component3(): Double = width

/** The vertical size of the shadow blur kernel. */
inline operator fun Shadow.component4(): Double = height

/** The algorithm used to blur the shadow. */
inline operator fun Shadow.component5(): BlurType = blurType

/** The shadow [Color]. */
inline operator fun Shadow.component6(): Color = color