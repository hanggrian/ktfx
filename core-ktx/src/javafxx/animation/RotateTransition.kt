@file:Suppress("NOTHING_TO_INLINE")

package javafxx.animation

import javafx.animation.RotateTransition
import javafx.scene.Node
import javafx.util.Duration
import javafx.util.Duration.millis

/** Construct a [RotateTransition] that animates this [Node]. */
inline fun Node?.rotateTransition(
    duration: Duration = millis(400.0)
): RotateTransition = RotateTransition(duration, this)