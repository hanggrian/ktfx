@file:Suppress("NOTHING_TO_INLINE")

package kotfx.experimental.animations

import javafx.animation.Interpolator

inline fun interpolatorOf(noinline curve: (Double) -> Double): Interpolator = object : Interpolator() {
    override fun curve(t: Double): Double = curve(t)
}