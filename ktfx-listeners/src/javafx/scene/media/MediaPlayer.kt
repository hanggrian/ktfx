@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
@file:Suppress("NOTHING_TO_INLINE")

package ktfx.listeners

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer

/** Sets the event handler to be called when an error occurs. */
inline fun MediaPlayer.onError(
    noinline action: () -> Unit
): Unit = setOnError(action)

/** Sets the marker event handler. */
inline fun MediaPlayer.onMarker(
    noinline action: (MediaMarkerEvent) -> Unit
): Unit = setOnMarker(action)

/** Sets the end of media event handler. */
inline fun MediaPlayer.onEndOfMedia(
    noinline action: () -> Unit
): Unit = setOnEndOfMedia(action)

/** Sets the [MediaPlayer.Status.READY] event handler. */
inline fun MediaPlayer.onReady(
    noinline action: () -> Unit
): Unit = setOnReady(action)

/** Sets the [MediaPlayer.Status.PLAYING] event handler. */
inline fun MediaPlayer.onPlaying(
    noinline action: () -> Unit
): Unit = setOnPlaying(action)

/** Sets the [MediaPlayer.Status.PAUSED] event handler. */
inline fun MediaPlayer.onPaused(
    noinline action: () -> Unit
): Unit = setOnPaused(action)

/** Sets the [MediaPlayer.Status.STOPPED] event handler. */
inline fun MediaPlayer.onStopped(
    noinline action: () -> Unit
): Unit = setOnStopped(action)

/** Sets the [MediaPlayer.Status.HALTED] event handler. */
inline fun MediaPlayer.onHalted(
    noinline action: () -> Unit
): Unit = setOnHalted(action)

/** Sets the repeat event handler. */
inline fun MediaPlayer.onRepeat(
    noinline action: () -> Unit
): Unit = setOnRepeat(action)

/** Sets the [MediaPlayer.Status.HALTED] event handler. */
inline fun MediaPlayer.onStalled(
    noinline action: () -> Unit
): Unit = setOnStalled(action)
