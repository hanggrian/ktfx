@file:Suppress("NOTHING_TO_INLINE")

package javafxx.animation

import javafx.animation.FillTransition
import javafx.scene.paint.Color
import javafx.scene.shape.Shape
import javafx.util.Duration
import javafx.util.Duration.millis

/** Construct a [FillTransition] that animates this [Shape]. */
inline fun Shape?.fillTransition(
    duration: Duration = millis(400.0),
    fromValue: Color? = null,
    toValue: Color? = null
): FillTransition = FillTransition(duration, this, fromValue, toValue)