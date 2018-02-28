package kotfx.scene.control.media

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun MediaPlayer.onMarker(
    context: CoroutineContext,
    action: suspend CoroutineScope.(MediaMarkerEvent) -> Unit
) = setOnMarker { event -> launch(context) { action(event) } }