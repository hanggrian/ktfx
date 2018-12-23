@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometries

import javafx.geometry.Point2D

/** The point with added coordinates. */
inline operator fun Point2D.plus(point: Point2D): Point2D = add(point)

/** The point with subtracted coordinates. */
inline operator fun Point2D.minus(point: Point2D): Point2D = subtract(point)