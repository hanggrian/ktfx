@file:JvmMultifileClass
@file:JvmName("AnimationsKt")
@file:Suppress("NOTHING_TO_INLINE", "UNUSED")

package kotfx

import javafx.animation.Interpolator

inline fun interpolatorOf(noinline curve: (Double) -> Double): Interpolator = object : Interpolator() {
    override fun curve(t: Double): Double = curve(t)
}