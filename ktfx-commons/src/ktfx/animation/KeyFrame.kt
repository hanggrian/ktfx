@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.KeyFrame
import javafx.animation.KeyValue
import javafx.util.Duration

/** Returns the `name` of this [KeyFrame]. */
inline operator fun KeyFrame.component1(): String = name

/** Returns the time offset of this [KeyFrame]. */
inline operator fun KeyFrame.component2(): Duration = time

/** Returns an immutable set of [KeyValue] instances. */
inline operator fun KeyFrame.component3(): Set<KeyValue> = values