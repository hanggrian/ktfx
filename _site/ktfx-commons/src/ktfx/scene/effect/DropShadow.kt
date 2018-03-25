@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.BlurType
import javafx.scene.effect.DropShadow
import javafx.scene.effect.Effect
import javafx.scene.paint.Color

/** The input for this [Effect]. */
inline operator fun DropShadow.component1(): Effect? = input

/** The radius of the shadow blur kernel. */
inline operator fun DropShadow.component2(): Double = radius

/** The horizontal size of the shadow blur kernel. */
inline operator fun DropShadow.component3(): Double = width

/** The vertical size of the shadow blur kernel. */
inline operator fun DropShadow.component4(): Double = height

/** The algorithm used to blur the shadow. */
inline operator fun DropShadow.component5(): BlurType = blurType

/** The spread of the shadow. */
inline operator fun DropShadow.component6(): Double = spread

/** The shadow [Color]. */
inline operator fun DropShadow.component7(): Color = color

/** The shadow offset in the x direction, in pixels. */
inline operator fun DropShadow.component8(): Double = offsetX

/** The shadow offset in the y direction, in pixels. */
inline operator fun DropShadow.component9(): Double = offsetY