@file:Suppress("NOTHING_TO_INLINE")

package javafxx.animation

import javafx.animation.TranslateTransition
import javafx.scene.Node
import javafx.util.Duration
import javafx.util.Duration.millis

/** Construct a [TranslateTransition] that animates this [Node]. */
inline fun Node?.translateTransition(
    duration: Duration = millis(400.0)
): TranslateTransition = TranslateTransition(duration, this)