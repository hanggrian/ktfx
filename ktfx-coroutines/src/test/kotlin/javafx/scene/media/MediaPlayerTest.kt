package ktfx.coroutines

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertTrue

@Ignore
class MediaPlayerTest {
    private lateinit var player: MediaPlayer

    @BeforeTest
    fun start() {
        initToolkit()
        player = MediaPlayer(Media(javaClass.classLoader.getResource("sample.flv")!!.toString()))
    }

    @Test
    fun onError() {
        var isCalled = false
        player.onError(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onError.run()
    }

    @Test
    fun onMarker() {
        // TODO create fake event
        // player.callOnMarker { assertFakeMediaMarkerEvent(it) }
        // player.onMarker.handle(fakeMediaMarkerEventOf())
    }

    @Test
    fun onEndOfMedia() {
        var isCalled = false
        player.onEndOfMedia(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onEndOfMedia.run()
    }

    @Test
    fun onReady() {
        var isCalled = false
        player.onReady(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onReady.run()
    }

    @Test
    fun onPlaying() {
        var isCalled = false
        player.onPlaying(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onPlaying.run()
    }

    @Test
    fun onPaused() {
        var isCalled = false
        player.onPaused(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onPaused.run()
    }

    @Test
    fun onStopped() {
        var isCalled = false
        player.onStopped(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onStopped.run()
    }

    @Test
    fun onHalted() {
        var isCalled = false
        player.onHalted(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onHalted.run()
    }

    @Test
    fun onRepeat() {
        var isCalled = false
        player.onRepeat(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onRepeat.run()
    }

    @Test
    fun onStalled() {
        var isCalled = false
        player.onStalled(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        player.onStalled.run()
    }
}
