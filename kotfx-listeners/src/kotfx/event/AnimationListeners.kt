@file:Suppress("NOTHING_TO_INLINE")

package kotfx.event

import javafx.animation.Animation
import javafx.event.ActionEvent

inline fun Animation.onFinished(
    noinline action: (ActionEvent) -> Unit
) = setOnFinished { event -> action(event) }