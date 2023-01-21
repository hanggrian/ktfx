@file:JvmMultifileClass
@file:JvmName("KtfxListenersKt")
@file:Suppress(
    "ktlint",
    "NOTHING_TO_INLINE",
)

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
public inline fun MediaPlayer.onError(noinline action: () -> Unit): Unit = setOnError(action)

/**
 * @see MediaPlayer.setOnMarker
 */
public inline fun MediaPlayer.onMarker(noinline action: (MediaMarkerEvent) -> Unit): Unit =
        setOnMarker(action)

/**
 * @see MediaPlayer.setOnEndOfMedia
 */
public inline fun MediaPlayer.onEndOfMedia(noinline action: () -> Unit): Unit =
        setOnEndOfMedia(action)

/**
 * @see MediaPlayer.setOnReady
 */
public inline fun MediaPlayer.onReady(noinline action: () -> Unit): Unit = setOnReady(action)

/**
 * @see MediaPlayer.setOnPlaying
 */
public inline fun MediaPlayer.onPlaying(noinline action: () -> Unit): Unit = setOnPlaying(action)

/**
 * @see MediaPlayer.setOnPaused
 */
public inline fun MediaPlayer.onPaused(noinline action: () -> Unit): Unit = setOnPaused(action)

/**
 * @see MediaPlayer.setOnStopped
 */
public inline fun MediaPlayer.onStopped(noinline action: () -> Unit): Unit = setOnStopped(action)

/**
 * @see MediaPlayer.setOnHalted
 */
public inline fun MediaPlayer.onHalted(noinline action: () -> Unit): Unit = setOnHalted(action)

/**
 * @see MediaPlayer.setOnRepeat
 */
public inline fun MediaPlayer.onRepeat(noinline action: () -> Unit): Unit = setOnRepeat(action)

/**
 * @see MediaPlayer.setOnStalled
 */
public inline fun MediaPlayer.onStalled(noinline action: () -> Unit): Unit = setOnStalled(action)
