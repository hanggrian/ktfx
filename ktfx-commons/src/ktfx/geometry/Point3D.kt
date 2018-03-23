@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.Point3D

/** The x coordinate. */
inline operator fun Point3D.component1(): Double = x

/** The y coordinate. */
inline operator fun Point3D.component2(): Double = y

/** The z coordinate. */
inline operator fun Point3D.component3(): Double = z