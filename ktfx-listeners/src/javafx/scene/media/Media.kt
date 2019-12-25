@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.media.Media

/** Set the event handler to be called when an error occurs. */
inline fun Media.onError(
    noinline action: () -> Unit
): Unit = setOnError(action)
