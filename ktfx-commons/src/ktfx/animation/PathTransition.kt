@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.PathTransition
import javafx.scene.Node
import javafx.scene.shape.Shape
import javafx.util.Duration
import javafx.util.Duration.millis

/** Construct a [PathTransition] that animates this [Node]. */
inline fun Node?.pathTransition(
    duration: Duration = millis(400.0),
    path: Shape? = null
): PathTransition = PathTransition(duration, path, this)