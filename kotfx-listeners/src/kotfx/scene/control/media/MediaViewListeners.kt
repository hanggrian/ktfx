@file:Suppress("NOTHING_TO_INLINE", "UsePropertyAccessSyntax")

package kotfx.scene.control.media

import javafx.event.EventHandler
import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView

inline fun MediaView.onError(
    noinline action: (MediaErrorEvent) -> Unit
) = setOnError(EventHandler(action))