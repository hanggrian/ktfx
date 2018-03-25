@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.Interpolator
import javafx.animation.KeyValue
import javafx.beans.value.WritableValue

/** The target. */
inline operator fun KeyValue.component1(): WritableValue<*> = target

/** The end value. */
inline operator fun KeyValue.component2(): Any = endValue

/** [Interpolator] to be used for calculating the key value along the particular interval. */
inline operator fun KeyValue.component3(): Interpolator = interpolator