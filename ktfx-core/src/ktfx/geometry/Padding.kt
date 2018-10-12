@file:Suppress("NOTHING_TO_INLINE", "unused")

package ktfx.geometry

import javafx.geometry.Insets

class Padding(
    top: Double = 0.0,
    right: Double = 0.0,
    bottom: Double = 0.0,
    left: Double = 0.0
) : Insets(top, right, bottom, left) {

    constructor(
        top: Number = 0.0,
        right: Number = 0.0,
        bottom: Number = 0.0,
        left: Number = 0.0
    ) : this(top.toDouble(), right.toDouble(), bottom.toDouble(), left.toDouble())

    companion object {

        val EMPTY: Padding = Padding(0.0, 0.0, 0.0, 0.0)

        inline fun top(top: Double): Padding = Padding(top, 0.0, 0.0, 0.0)

        fun top(top: Number): Padding = top(top.toDouble())

        inline fun right(right: Double): Padding = Padding(0.0, right, 0.0, 0.0)

        fun right(right: Number): Padding = right(right.toDouble())

        inline fun bottom(bottom: Double): Padding = Padding(0.0, 0.0, bottom, 0.0)

        fun bottom(bottom: Number): Padding = bottom(bottom.toDouble())

        inline fun left(left: Double): Padding = Padding(0.0, 0.0, 0.0, left)

        fun left(left: Number): Padding = left(left.toDouble())
    }
}