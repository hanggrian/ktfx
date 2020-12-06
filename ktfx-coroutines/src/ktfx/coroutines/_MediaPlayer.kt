@file:JvmMultifileClass
@file:JvmName("KtfxCoroutinesKt")

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
public fun MediaPlayer.onError(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnError { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnMarker
 */
public fun MediaPlayer.onMarker(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.(MediaMarkerEvent) -> Unit
) {
    return setOnMarker { event -> GlobalScope.launch(context) { action(event) } }
}

/**
 * @see MediaPlayer.setOnEndOfMedia
 */
public fun MediaPlayer.onEndOfMedia(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnEndOfMedia { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnReady
 */
public fun MediaPlayer.onReady(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnReady { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnPlaying
 */
public fun MediaPlayer.onPlaying(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnPlaying { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnPaused
 */
public fun MediaPlayer.onPaused(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnPaused { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnStopped
 */
public fun MediaPlayer.onStopped(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnStopped { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnHalted
 */
public fun MediaPlayer.onHalted(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnHalted { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnRepeat
 */
public fun MediaPlayer.onRepeat(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnRepeat { GlobalScope.launch(context) { action() } }
}

/**
 * @see MediaPlayer.setOnStalled
 */
public fun MediaPlayer.onStalled(
    context: CoroutineContext = Dispatchers.JavaFx,
    action: suspend    
    CoroutineScope.() -> Unit
) {
    return setOnStalled { GlobalScope.launch(context) { action() } }
}
