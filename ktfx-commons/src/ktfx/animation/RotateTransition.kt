@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.RotateTransition
import javafx.scene.Node
import javafx.util.Duration

/** Construct a [RotateTransition] that animates this [Node]. */
inline fun Node?.rotateTransition(
    duration: Duration = Duration.millis(400.0)
): RotateTransition = RotateTransition(duration, this)