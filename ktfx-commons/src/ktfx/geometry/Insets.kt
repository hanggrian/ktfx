@file:Suppress("NOTHING_TO_INLINE")

package ktfx.geometry

/** The inset on the top side. */
inline operator fun Padding.component1(): Double = top

/** The inset on the right side. */
inline operator fun Padding.component2(): Double = right

/** The inset on the bottom side. */
inline operator fun Padding.component3(): Double = bottom

/** The inset on the left side. */
inline operator fun Padding.component4(): Double = left