@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.FadeTransition
import javafx.scene.Node
import javafx.util.Duration

/** Construct a [FadeTransition] that animates this [Node]. */
inline fun Node?.fadeTransition(
    duration: Duration = Duration.millis(400.0)
): FadeTransition = FadeTransition(duration, this)