@file:Suppress("NOTHING_TO_INLINE")

package ktfx.scene.transform

import javafx.geometry.Point3D
import javafx.scene.transform.Rotate

/** Defines the angle of rotation measured in degrees. */
inline operator fun Rotate.component1(): Double = angle

/** Defines the X coordinate of the rotation pivot point. */
inline operator fun Rotate.component2(): Double = pivotX

/** Defines the Y coordinate of the rotation pivot point. */
inline operator fun Rotate.component3(): Double = pivotY

/** Defines the Z coordinate of the rotation pivot point. */
inline operator fun Rotate.component4(): Double = pivotZ

/** Defines the axis of rotation at the pivot point. */
inline operator fun Rotate.component5(): Point3D? = axis