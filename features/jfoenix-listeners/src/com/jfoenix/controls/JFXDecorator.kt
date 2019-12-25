@file:JvmMultifileClass
@file:JvmName("JfoenixListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.jfoenix.listeners

import com.jfoenix.controls.JFXDecorator

/** Sets a speficed runnable when clicking on the close button. */
inline fun JFXDecorator.onCloseButtonAction(
    noinline action: () -> Unit
): Unit = setOnCloseButtonAction(action)
