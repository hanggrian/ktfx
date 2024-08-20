package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.scene.media.MediaView
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Ignore
import kotlin.test.Test

@Ignore
class MediaViewTest : ApplicationTest() {
    private lateinit var media: MediaView

    override fun start(stage: Stage) {
        stage.testScene<MediaView>()
        media = MediaView()
    }

    // TODO create fake event
    @Test
    fun onError() {
        // media.callOnError { assertFakeMediaErrorEvent(it) }
        // media.onError.handle(fakeMediaErrorEventOf())
    }
}
