@file:JvmMultifileClass
@file:JvmName("PointsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometries

import javafx.geometry.Point3D

/** The x coordinate. */
inline operator fun Point3D.component1(): Double = x

/** The y coordinate. */
inline operator fun Point3D.component2(): Double = y

/** The z coordinate. */
inline operator fun Point3D.component3(): Double = z

/** The point with added coordinates. */
inline operator fun Point3D.plus(point: Point3D): Point3D =
    add(point)

/** The point with subtracted coordinates. */
inline operator fun Point3D.minus(point: Point3D): Point3D =
    subtract(point)

/** The point with multiplied coordinates. */
inline operator fun Point3D.times(factor: Double): Point3D =
    multiply(factor)
