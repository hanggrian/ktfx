@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.ScaleTransition
import javafx.scene.Node
import javafx.util.Duration

/** Construct a [ScaleTransition] that animates this [Node]. */
inline fun Node?.scaleTransition(
    duration: Duration = Duration.millis(400.0)
): ScaleTransition = ScaleTransition(duration, this)