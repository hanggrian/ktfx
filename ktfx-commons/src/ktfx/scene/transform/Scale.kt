@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.scene.transform.Scale

/** Defines the factor by which coordinates are scaled along the X axis direction. */
inline operator fun Scale.component1(): Double = x

/** Defines the factor by which coordinates are scaled along the Y axis direction. */
inline operator fun Scale.component2(): Double = y

/** Defines the factor by which coordinates are scaled along the Z axis direction. */
inline operator fun Scale.component3(): Double = z

/** Defines the X coordinate about which point the scale occurs. */
inline operator fun Scale.component4(): Double = pivotX

/** Defines the Y coordinate about which point the scale occurs. */
inline operator fun Scale.component5(): Double = pivotY

/** Defines the Z coordinate about which point the scale occurs. */
inline operator fun Scale.component6(): Double = pivotZ