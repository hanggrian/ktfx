@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView

/** Sets the error event handler. */
inline fun MediaView.onError(
    noinline action: (MediaErrorEvent) -> Unit
): Unit = setOnError(action)
