@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometries

import javafx.geometry.Point2D
import javafx.geometry.Point3D

/** The point with added coordinates. */
inline operator fun Point2D.plus(point: Point2D): Point2D =
    add(point)

/** The point with subtracted coordinates. */
inline operator fun Point2D.minus(point: Point2D): Point2D =
    subtract(point)

/** The point with multiplied coordinates. */
inline operator fun Point2D.times(factor: Number): Point2D =
    multiply(factor.toDouble())

/** The point with added coordinates. */
inline operator fun Point3D.plus(point: Point3D): Point3D =
    add(point)

/** The point with subtracted coordinates. */
inline operator fun Point3D.minus(point: Point3D): Point3D =
    subtract(point)

/** The point with multiplied coordinates. */
inline operator fun Point3D.times(factor: Number): Point3D =
    multiply(factor.toDouble())
