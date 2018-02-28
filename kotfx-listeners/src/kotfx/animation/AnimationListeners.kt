@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.animation

import javafx.animation.Animation
import javafx.event.ActionEvent
import javafx.event.EventHandler

inline fun Animation.onFinished(
    noinline action: (ActionEvent) -> Unit
) = setOnFinished(EventHandler(action))