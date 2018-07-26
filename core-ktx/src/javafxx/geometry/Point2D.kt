@file:Suppress("NOTHING_TO_INLINE")

package javafxx.geometry

import javafx.geometry.Point2D

/** The x coordinate. */
inline operator fun Point2D.component1(): Double = x

/** The y coordinate. */
inline operator fun Point2D.component2(): Double = y

/** The point with added coordinates. */
inline operator fun Point2D.plus(point: Point2D): Point2D = add(point)

/** The point with subtracted coordinates. */
inline operator fun Point2D.minus(point: Point2D): Point2D = subtract(point)