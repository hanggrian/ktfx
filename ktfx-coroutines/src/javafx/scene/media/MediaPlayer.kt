@file:JvmMultifileClass
@file:JvmName("FxCoroutinesKt")

package ktfx.coroutines

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/** Sets the event handler to be called when an error occurs. */
fun MediaPlayer.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnError { GlobalScope.launch(context) { action() } }

/** Sets the marker event handler. */
fun MediaPlayer.onMarker(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.(MediaMarkerEvent) -> Unit
): Unit = setOnMarker { event -> GlobalScope.launch(context) { action(event) } }

/** Sets the end of media event handler. */
fun MediaPlayer.onEndOfMedia(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnEndOfMedia { GlobalScope.launch(context) { action() } }

/** Sets the [MediaPlayer.Status.READY] event handler. */
fun MediaPlayer.onReady(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnReady { GlobalScope.launch(context) { action() } }

/** Sets the [MediaPlayer.Status.PLAYING] event handler. */
fun MediaPlayer.onPlaying(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnPlaying { GlobalScope.launch(context) { action() } }

/** Sets the [MediaPlayer.Status.PAUSED] event handler. */
fun MediaPlayer.onPaused(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnPaused { GlobalScope.launch(context) { action() } }

/** Sets the [MediaPlayer.Status.STOPPED] event handler. */
fun MediaPlayer.onStopped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnStopped { GlobalScope.launch(context) { action() } }

/** Sets the [MediaPlayer.Status.HALTED] event handler. */
fun MediaPlayer.onHalted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnHalted { GlobalScope.launch(context) { action() } }

/** Sets the repeat event handler. */
fun MediaPlayer.onRepeat(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnRepeat { GlobalScope.launch(context) { action() } }

/** Sets the [MediaPlayer.Status.HALTED] event handler. */
fun MediaPlayer.onStalled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend CoroutineScope.() -> Unit
): Unit = setOnStalled { GlobalScope.launch(context) { action() } }
