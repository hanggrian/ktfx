@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.scene.transform.Translate

/** Defines the distance by which coordinates are translated in the X axis direction. */
inline operator fun Translate.component1(): Double = x

/** Defines the distance by which coordinates are translated in the Y axis direction. */
inline operator fun Translate.component2(): Double = y

/** Defines the distance by which coordinates are translated in the Z axis direction. */
inline operator fun Translate.component3(): Double = z