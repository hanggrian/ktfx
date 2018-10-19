@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.TranslateTransition
import javafx.scene.Node
import javafx.util.Duration

/** Construct a [TranslateTransition] that animates this [Node]. */
inline fun Node?.translateTransition(
    duration: Duration = Duration.millis(400.0)
): TranslateTransition = TranslateTransition(duration, this)