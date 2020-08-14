@file:JvmMultifileClass
@file:JvmName("FxListenersKt")
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
inline fun MediaPlayer.onError(noinline action: () -> Unit): Unit = setOnError(action)

/**
 * @see MediaPlayer.setOnMarker
 */
inline fun MediaPlayer.onMarker(noinline action: (MediaMarkerEvent) -> Unit): Unit =
    setOnMarker(action)

/**
 * @see MediaPlayer.setOnEndOfMedia
 */
inline fun MediaPlayer.onEndOfMedia(noinline action: () -> Unit): Unit = setOnEndOfMedia(action)

/**
 * @see MediaPlayer.setOnReady
 */
inline fun MediaPlayer.onReady(noinline action: () -> Unit): Unit = setOnReady(action)

/**
 * @see MediaPlayer.setOnPlaying
 */
inline fun MediaPlayer.onPlaying(noinline action: () -> Unit): Unit = setOnPlaying(action)

/**
 * @see MediaPlayer.setOnPaused
 */
inline fun MediaPlayer.onPaused(noinline action: () -> Unit): Unit = setOnPaused(action)

/**
 * @see MediaPlayer.setOnStopped
 */
inline fun MediaPlayer.onStopped(noinline action: () -> Unit): Unit = setOnStopped(action)

/**
 * @see MediaPlayer.setOnHalted
 */
inline fun MediaPlayer.onHalted(noinline action: () -> Unit): Unit = setOnHalted(action)

/**
 * @see MediaPlayer.setOnRepeat
 */
inline fun MediaPlayer.onRepeat(noinline action: () -> Unit): Unit = setOnRepeat(action)

/**
 * @see MediaPlayer.setOnStalled
 */
inline fun MediaPlayer.onStalled(noinline action: () -> Unit): Unit = setOnStalled(action)
