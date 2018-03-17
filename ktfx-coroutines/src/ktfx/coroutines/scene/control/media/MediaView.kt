package ktfx.coroutines

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

fun MediaView.onError(
    context: CoroutineContext = FX,
    action: suspend CoroutineScope.(MediaErrorEvent) -> Unit
) = setOnError { event -> launch(context) { action(event) } }