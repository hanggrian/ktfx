package ktfx.coroutines

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseMediaPlayerTest
import kotlin.test.Ignore

@Ignore
class MediaPlayerTest : BaseMediaPlayerTest() {

    override fun MediaPlayer.callOnError(action: () -> Unit) =
        onError(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnMarker(action: (MediaMarkerEvent) -> Unit) =
        onMarker(Dispatchers.Unconfined) { action(it) }

    override fun MediaPlayer.callOnEndOfMedia(action: () -> Unit) =
        onEndOfMedia(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnReady(action: () -> Unit) =
        onReady(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnPlaying(action: () -> Unit) =
        onPlaying(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnPaused(action: () -> Unit) =
        onPaused(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnStopped(action: () -> Unit) =
        onStopped(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnHalted(action: () -> Unit) =
        onHalted(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnRepeat(action: () -> Unit) =
        onRepeat(Dispatchers.Unconfined) { action() }

    override fun MediaPlayer.callOnStalled(action: () -> Unit) =
        onStalled(Dispatchers.Unconfined) { action() }
}