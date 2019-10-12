@file:JvmMultifileClass
@file:JvmName("PointsKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometries

import javafx.geometry.Point2D

/** The x coordinate. */
inline operator fun Point2D.component1(): Double = x

/** The y coordinate. */
inline operator fun Point2D.component2(): Double = y

/** The point with added coordinates. */
inline operator fun Point2D.plus(point: Point2D): Point2D =
    add(point)

/** The point with subtracted coordinates. */
inline operator fun Point2D.minus(point: Point2D): Point2D =
    subtract(point)

/** The point with multiplied coordinates. */
inline operator fun Point2D.times(factor: Double): Point2D =
    multiply(factor)
