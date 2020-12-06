@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlin.Suppress
import kotlin.Unit
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName

/**
 * @see MediaPlayer.setOnError
 */
public inline fun MediaPlayer.onError(noinline action: () -> Unit) {
    return setOnError(action)
}

/**
 * @see MediaPlayer.setOnMarker
 */
public inline fun MediaPlayer.onMarker(noinline action: (MediaMarkerEvent) -> Unit) {
    return setOnMarker(action)
}

/**
 * @see MediaPlayer.setOnEndOfMedia
 */
public inline fun MediaPlayer.onEndOfMedia(noinline action: () -> Unit) {
    return setOnEndOfMedia(action)
}

/**
 * @see MediaPlayer.setOnReady
 */
public inline fun MediaPlayer.onReady(noinline action: () -> Unit) {
    return setOnReady(action)
}

/**
 * @see MediaPlayer.setOnPlaying
 */
public inline fun MediaPlayer.onPlaying(noinline action: () -> Unit) {
    return setOnPlaying(action)
}

/**
 * @see MediaPlayer.setOnPaused
 */
public inline fun MediaPlayer.onPaused(noinline action: () -> Unit) {
    return setOnPaused(action)
}

/**
 * @see MediaPlayer.setOnStopped
 */
public inline fun MediaPlayer.onStopped(noinline action: () -> Unit) {
    return setOnStopped(action)
}

/**
 * @see MediaPlayer.setOnHalted
 */
public inline fun MediaPlayer.onHalted(noinline action: () -> Unit) {
    return setOnHalted(action)
}

/**
 * @see MediaPlayer.setOnRepeat
 */
public inline fun MediaPlayer.onRepeat(noinline action: () -> Unit) {
    return setOnRepeat(action)
}

/**
 * @see MediaPlayer.setOnStalled
 */
public inline fun MediaPlayer.onStalled(noinline action: () -> Unit) {
    return setOnStalled(action)
}
