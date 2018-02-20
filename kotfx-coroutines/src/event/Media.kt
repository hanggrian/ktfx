@file:JvmMultifileClass
@file:JvmName("EventHandlersKt")

package kotfx.coroutines

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import javafx.scene.media.MediaView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun MediaPlayer.onMarker(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(MediaMarkerEvent) -> Unit
) = setOnMarker { event -> launch(context) { action(event) } }

fun MediaView.onError(
    context: CoroutineContext = JavaFx,
    action: suspend CoroutineScope.(MediaErrorEvent) -> Unit
) = setOnError { event -> launch(context) { action(event) } }