@file:Suppress("NOTHING_TO_INLINE")

package javafxx.animation

import javafx.animation.ScaleTransition
import javafx.scene.Node
import javafx.util.Duration
import javafx.util.Duration.millis

/** Construct a [ScaleTransition] that animates this [Node]. */
inline fun Node?.scaleTransition(
    duration: Duration = millis(400.0)
): ScaleTransition = ScaleTransition(duration, this)