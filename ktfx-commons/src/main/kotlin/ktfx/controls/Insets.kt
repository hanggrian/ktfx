@file:Suppress("NOTHING_TO_INLINE")

package ktfx.controls

import javafx.geometry.Insets

/** Empty insets. An [Insets] instance with all offsets equal to zero. */
inline fun insetsOf(): Insets = Insets.EMPTY

/** Create an inset where [Int] number will be applied to all side. */
fun insetsOf(all: Int): Insets = insetsOf(all.toDouble())

/** Create an inset where [Long] number will be applied to all side. */
fun insetsOf(all: Long): Insets = insetsOf(all.toDouble())

/** Create an inset where [Double] number will be applied to all side. */
inline fun insetsOf(all: Double): Insets = Insets(all)

/** Create an inset where [Int] number will be applied to both side. */
fun insetsOf(vertical: Int = 0, horizontal: Int = 0): Insets =
    insetsOf(vertical.toDouble(), horizontal.toDouble())

/** Create an inset where [Long] number will be applied to both side. */
fun insetsOf(vertical: Long = 0, horizontal: Long = 0): Insets =
    insetsOf(vertical.toDouble(), horizontal.toDouble())

/** Create an inset where [Double] number will be applied to both side. */
inline fun insetsOf(vertical: Double = 0.0, horizontal: Double = 0.0): Insets =
    Insets(vertical, horizontal, vertical, horizontal)

/** Create an inset where [Int] number will be applied to each side. */
fun insetsOf(top: Int = 0, right: Int = 0, bottom: Int = 0, left: Int = 0): Insets =
    insetsOf(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble())

/** Create an inset where [Long] number will be applied to each side. */
fun insetsOf(top: Long = 0L, right: Long = 0L, bottom: Long = 0L, left: Long = 0L): Insets =
    insetsOf(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble())

/** Create an inset where [Double] number will be applied to each side. */
inline fun insetsOf(
    top: Double = 0.0,
    right: Double = 0.0,
    bottom: Double = 0.0,
    left: Double = 0.0
): Insets = Insets(top, right, bottom, left)
