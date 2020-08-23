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
inline fun MediaPlayer.onError(noinline action: () -> Unit) {
    return setOnError(action)
}

/**
 * @see MediaPlayer.setOnMarker
 */
inline fun MediaPlayer.onMarker(noinline action: (MediaMarkerEvent) -> Unit) {
    return setOnMarker(action)
}

/**
 * @see MediaPlayer.setOnEndOfMedia
 */
inline fun MediaPlayer.onEndOfMedia(noinline action: () -> Unit) {
    return setOnEndOfMedia(action)
}

/**
 * @see MediaPlayer.setOnReady
 */
inline fun MediaPlayer.onReady(noinline action: () -> Unit) {
    return setOnReady(action)
}

/**
 * @see MediaPlayer.setOnPlaying
 */
inline fun MediaPlayer.onPlaying(noinline action: () -> Unit) {
    return setOnPlaying(action)
}

/**
 * @see MediaPlayer.setOnPaused
 */
inline fun MediaPlayer.onPaused(noinline action: () -> Unit) {
    return setOnPaused(action)
}

/**
 * @see MediaPlayer.setOnStopped
 */
inline fun MediaPlayer.onStopped(noinline action: () -> Unit) {
    return setOnStopped(action)
}

/**
 * @see MediaPlayer.setOnHalted
 */
inline fun MediaPlayer.onHalted(noinline action: () -> Unit) {
    return setOnHalted(action)
}

/**
 * @see MediaPlayer.setOnRepeat
 */
inline fun MediaPlayer.onRepeat(noinline action: () -> Unit) {
    return setOnRepeat(action)
}

/**
 * @see MediaPlayer.setOnStalled
 */
inline fun MediaPlayer.onStalled(noinline action: () -> Unit) {
    return setOnStalled(action)
}
