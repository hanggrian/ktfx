@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometries

import javafx.geometry.Dimension2D

/** The width of the dimension. */
inline operator fun Dimension2D.component1(): Double = width

/** The height of the dimension. */
inline operator fun Dimension2D.component2(): Double = height
