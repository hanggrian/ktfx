@file:Suppress("NOTHING_TO_INLINE")

package ktfx.print

import javafx.print.Paper

/** Get the paper name. */
inline operator fun Paper.component1(): String = name

/** Get the width of the paper in points (1/72 inch). */
inline operator fun Paper.component2(): Double = width

/** Get the height of the paper in points (1/72 inch). */
inline operator fun Paper.component3(): Double = height