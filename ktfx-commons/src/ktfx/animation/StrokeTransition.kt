@file:Suppress("NOTHING_TO_INLINE")

package ktfx.animation

import javafx.animation.StrokeTransition
import javafx.scene.paint.Color
import javafx.scene.shape.Shape
import javafx.util.Duration

/** Construct a [StrokeTransition] that animates this [Shape]. */
inline fun Shape?.strokeTransition(
    duration: Duration = Duration.millis(400.0),
    fromValue: Color? = null,
    toValue: Color? = null
): StrokeTransition = StrokeTransition(duration, this, fromValue, toValue)