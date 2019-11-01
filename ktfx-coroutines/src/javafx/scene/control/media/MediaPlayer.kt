@file:JvmMultifileClass
@file:JvmName("CoroutinesKt")
@file:Suppress("PackageDirectoryMismatch", "SpellCheckingInspection")

package ktfx.coroutines

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch

/** Sets the marker event handler. */
fun MediaPlayer.onMarker(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MediaMarkerEvent) -> Unit
): Unit = setOnMarker { event -> GlobalScope.launch(context) { action(event) } }
