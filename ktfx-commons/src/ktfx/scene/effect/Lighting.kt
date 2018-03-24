@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.effect

import javafx.scene.effect.Effect
import javafx.scene.effect.Light
import javafx.scene.effect.Lighting

/** The light source for this [Lighting] effect. */
inline operator fun Lighting.component1(): Light? = light

/** The optional bump map input. */
inline operator fun Lighting.component2(): Effect = bumpInput

/** The content input for this [Effect]. */
inline operator fun Lighting.component3(): Effect? = contentInput

/** The diffuse constant. */
inline operator fun Lighting.component4(): Double = diffuseConstant

/** The specular constant. */
inline operator fun Lighting.component5(): Double = specularConstant

/** The specular exponent. */
inline operator fun Lighting.component6(): Double = specularExponent

/** The surface scale factor. */
inline operator fun Lighting.component7(): Double = surfaceScale