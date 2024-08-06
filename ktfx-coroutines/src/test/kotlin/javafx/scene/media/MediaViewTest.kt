package ktfx.coroutines

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.media.MediaView
import kotlin.test.BeforeTest
import kotlin.test.Test

class MediaViewTest {
    private lateinit var media: MediaView

    @BeforeTest
    fun start() {
        initToolkit()
        media = MediaView()
    }

    @Test
    fun onError() {
        // TODO create fake event
        // media.callOnError { assertFakeMediaErrorEvent(it) }
        // media.onError.handle(fakeMediaErrorEventOf())
    }
}
