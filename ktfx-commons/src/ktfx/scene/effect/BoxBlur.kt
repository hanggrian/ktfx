@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.BoxBlur
import javafx.scene.effect.Effect

/** The horizontal dimension of the blur effect. */
inline operator fun BoxBlur.component1(): Double = width

/** The vertical dimension of the blur effect. */
inline operator fun BoxBlur.component2(): Double = height

/** The number of times to iterate the blur effect to improve its "quality" or "smoothness". */
inline operator fun BoxBlur.component3(): Int = iterations