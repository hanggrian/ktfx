@file:JvmMultifileClass
@file:JvmName("ListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer

/** Sets the marker event handler. */
inline fun MediaPlayer.onMarker(
    noinline action: (MediaMarkerEvent) -> Unit
): Unit = setOnMarker { event -> action(event) }
