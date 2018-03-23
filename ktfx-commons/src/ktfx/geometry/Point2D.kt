@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.Point2D

/** The x coordinate. */
inline operator fun Point2D.component1(): Double = x

/** The y coordinate. */
inline operator fun Point2D.component2(): Double = y