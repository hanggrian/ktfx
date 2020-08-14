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
import kotlin.Unit
import kotlin.coroutines.CoroutineContext
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see MediaPlayer.setOnError
 */
fun MediaPlayer.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnError { GlobalScope.launch(context) { action() } }

/**
 * @see MediaPlayer.setOnMarker
 */
fun MediaPlayer.onMarker(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MediaMarkerEvent) -> Unit
): Unit = setOnMarker { event ->
    GlobalScope.launch(context) { action(event) }
}

/**
 * @see MediaPlayer.setOnEndOfMedia
 */
fun MediaPlayer.onEndOfMedia(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnEndOfMedia {
    GlobalScope.launch(context) {
        action()
    }
}

/**
 * @see MediaPlayer.setOnReady
 */
fun MediaPlayer.onReady(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnReady { GlobalScope.launch(context) { action() } }

/**
 * @see MediaPlayer.setOnPlaying
 */
fun MediaPlayer.onPlaying(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnPlaying { GlobalScope.launch(context) { action() } }

/**
 * @see MediaPlayer.setOnPaused
 */
fun MediaPlayer.onPaused(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnPaused { GlobalScope.launch(context) { action() } }

/**
 * @see MediaPlayer.setOnStopped
 */
fun MediaPlayer.onStopped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnStopped { GlobalScope.launch(context) { action() } }

/**
 * @see MediaPlayer.setOnHalted
 */
fun MediaPlayer.onHalted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnHalted { GlobalScope.launch(context) { action() } }

/**
 * @see MediaPlayer.setOnRepeat
 */
fun MediaPlayer.onRepeat(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnRepeat { GlobalScope.launch(context) { action() } }

/**
 * @see MediaPlayer.setOnStalled
 */
fun MediaPlayer.onStalled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
): Unit = setOnStalled { GlobalScope.launch(context) { action() } }
