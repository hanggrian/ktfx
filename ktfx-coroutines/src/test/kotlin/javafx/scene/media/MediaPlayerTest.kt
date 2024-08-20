package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.scene.media.Media
import javafx.scene.media.MediaPlayer
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertTrue

// fails on CI
@Ignore
class MediaPlayerTest : ApplicationTest() {
    private lateinit var player: MediaPlayer

    override fun start(stage: Stage) {
        stage.testScene<MediaPlayer>()
        player = MediaPlayer(Media(javaClass.classLoader.getResource("sample.mp3")!!.toString()))
    }

    @Test
    fun onError() {
        var assigned = false
        interact {
            player.onError {
                assigned = true
            }
            player.onError.run()
        }
        assertTrue(assigned)
    }

    // TODO create fake event
    @Test
    fun onMarker() {
        // player.callOnMarker { assertFakeMediaMarkerEvent(it) }
        // player.onMarker.handle(fakeMediaMarkerEventOf())
    }

    @Test
    fun onEndOfMedia() {
        var assigned = false
        interact {
            player.onEndOfMedia {
                assigned = true
            }
            player.onEndOfMedia.run()
        }
        assertTrue(assigned)
    }

    @Test
    fun onReady() {
        var assigned = false
        interact {
            player.onReady {
                assigned = true
            }
            player.onReady.run()
        }
        assertTrue(assigned)
    }

    @Test
    fun onPlaying() {
        var assigned = false
        interact {
            player.onPlaying {
                assigned = true
            }
            player.onPlaying.run()
        }
        assertTrue(assigned)
    }

    @Test
    fun onPaused() {
        var assigned = false
        interact {
            player.onPaused {
                assigned = true
            }
            player.onPaused.run()
        }
        assertTrue(assigned)
    }

    @Test
    fun onStopped() {
        var assigned = false
        interact {
            player.onStopped {
                assigned = true
            }
            player.onStopped.run()
        }
        assertTrue(assigned)
    }

    @Test
    fun onHalted() {
        var assigned = false
        interact {
            player.onHalted {
                assigned = true
            }
            player.onHalted.run()
        }
        assertTrue(assigned)
    }

    @Test
    fun onRepeat() {
        var assigned = false
        interact {
            player.onRepeat {
                assigned = true
            }
            player.onRepeat.run()
        }
        assertTrue(assigned)
    }

    @Test
    fun onStalled() {
        var assigned = false
        interact {
            player.onStalled {
                assigned = true
            }
            player.onStalled.run()
        }
        assertTrue(assigned)
    }
}
