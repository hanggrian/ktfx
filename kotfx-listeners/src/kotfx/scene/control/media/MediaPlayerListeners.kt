@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control.media

import javafx.event.EventHandler
import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer

inline fun MediaPlayer.onMarker(
    noinline action: (MediaMarkerEvent) -> Unit
) = setOnMarker(EventHandler(action))