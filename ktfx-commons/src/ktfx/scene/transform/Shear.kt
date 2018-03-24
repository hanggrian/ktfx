@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.scene.transform.Shear

/**
 * Defines the multiplier by which coordinates are shifted in the direction
 * of the positive X axis as a factor of their Y coordinate.
 */
inline operator fun Shear.component1(): Double = x

/**
 * Defines the multiplier by which coordinates are shifted in the direction
 * of the positive Y axis as a factor of their X coordinate.
 */
inline operator fun Shear.component2(): Double = y

/** Defines the X coordinate of the shear pivot point. */
inline operator fun Shear.component3(): Double = pivotX

/** Defines the Y coordinate of the shear pivot point. */
inline operator fun Shear.component4(): Double = pivotY