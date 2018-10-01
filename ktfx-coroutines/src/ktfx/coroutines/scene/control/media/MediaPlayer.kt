@file:Suppress("PackageDirectoryMismatch")

/* ktlint-disable package-name */
package ktfx.coroutines

/* ktlint-enable package-name */

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.GlobalScope
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

/** Sets the marker event handler. */
fun MediaPlayer.onMarker(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MediaMarkerEvent) -> Unit
): Unit = setOnMarker { event -> GlobalScope.launch(context) { action(event) } }