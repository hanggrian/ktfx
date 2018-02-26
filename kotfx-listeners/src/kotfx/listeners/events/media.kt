@file:JvmMultifileClass
@file:JvmName("EventsKt")
@file:Suppress("NOTHING_TO_INLINE")

package kotfx.listeners

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView

inline fun MediaPlayer.onMarker(
    noinline action: (MediaMarkerEvent) -> Unit
) = setOnMarker { event -> action(event) }

inline fun MediaView.onError(
    noinline action: (MediaErrorEvent) -> Unit
) = setOnError { event -> action(event) }