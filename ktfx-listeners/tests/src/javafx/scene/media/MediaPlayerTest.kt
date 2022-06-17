package ktfx.listeners

import javafx.scene.media.MediaMarkerEvent
import javafx.scene.media.MediaPlayer
import com.hendraanggrian.ktfx.test.BaseMediaPlayerTest
import kotlin.test.Ignore

@Ignore
class MediaPlayerTest : BaseMediaPlayerTest() {

    override fun MediaPlayer.callOnError(action: () -> Unit) = onError(action)
    override fun MediaPlayer.callOnMarker(action: (MediaMarkerEvent) -> Unit) = onMarker(action)
    override fun MediaPlayer.callOnEndOfMedia(action: () -> Unit) = onEndOfMedia(action)
    override fun MediaPlayer.callOnReady(action: () -> Unit) = onReady(action)
    override fun MediaPlayer.callOnPlaying(action: () -> Unit) = onPlaying(action)
    override fun MediaPlayer.callOnPaused(action: () -> Unit) = onPaused(action)
    override fun MediaPlayer.callOnStopped(action: () -> Unit) = onStopped(action)
    override fun MediaPlayer.callOnHalted(action: () -> Unit) = onHalted(action)
    override fun MediaPlayer.callOnRepeat(action: () -> Unit) = onRepeat(action)
    override fun MediaPlayer.callOnStalled(action: () -> Unit) = onStalled(action)
}
