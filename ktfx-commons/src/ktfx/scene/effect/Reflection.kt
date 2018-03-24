@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Effect
import javafx.scene.effect.Reflection

/** The input for this [Effect]. */
inline operator fun Reflection.component1(): Effect? = input

/** The top offset adjustment, which is the distance between the bottom of the input and the top of the reflection. */
inline operator fun Reflection.component2(): Double = topOffset

/** The top opacity value, which is the opacity of the reflection at its top extreme. */
inline operator fun Reflection.component3(): Double = topOpacity

/** The bottom opacity value, which is the opacity of the reflection at its bottom extreme. */
inline operator fun Reflection.component4(): Double = bottomOpacity

/** The fraction of the input that is visible in the reflection. */
inline operator fun Reflection.component5(): Double = fraction