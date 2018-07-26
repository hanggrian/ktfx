@file:Suppress("NOTHING_TO_INLINE")

package javafxx.geometry

import javafx.geometry.Insets

/** The inset on the top side. */
inline operator fun Insets.component1(): Double = top

/** The inset on the right side. */
inline operator fun Insets.component2(): Double = right

/** The inset on the bottom side. */
inline operator fun Insets.component3(): Double = bottom

/** The inset on the left side. */
inline operator fun Insets.component4(): Double = left