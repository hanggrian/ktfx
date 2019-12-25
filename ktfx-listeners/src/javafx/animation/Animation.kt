@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.animation.Animation
import javafx.event.ActionEvent

/** The action to be executed at the conclusion of this [Animation]. */
inline fun Animation.onFinished(
    noinline action: (ActionEvent) -> Unit
): Unit = setOnFinished(action)
