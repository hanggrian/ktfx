@file:JvmMultifileClass
@file:JvmName("EventsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.animation.Animation
import javafx.event.ActionEvent

inline fun Animation.onFinished(
    noinline action: (ActionEvent) -> Unit
) = setOnFinished { event -> action(event) }