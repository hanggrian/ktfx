@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.listeners

import com.jfoenix.transitions.JFXAnimationTimer

inline fun JFXAnimationTimer.onFinished(
    noinline action: () -> Unit
): Unit = setOnFinished(action)
