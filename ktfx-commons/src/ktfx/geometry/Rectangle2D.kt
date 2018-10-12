@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

import javafx.geometry.Rectangle2D

/** The min x of the rectangle. */
inline operator fun Rectangle2D.component1(): Double = minX

/** The min y of the rectangle. */
inline operator fun Rectangle2D.component2(): Double = minY

/** The width of the rectangle. */
inline operator fun Rectangle2D.component3(): Double = width

/** The height of the rectangle. */
inline operator fun Rectangle2D.component4(): Double = height

/** The max x of the rectangle. */
inline operator fun Rectangle2D.component5(): Double = maxX

/** The max y of the rectangle. */
inline operator fun Rectangle2D.component6(): Double = maxY