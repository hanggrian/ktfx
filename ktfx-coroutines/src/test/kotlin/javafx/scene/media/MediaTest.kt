package ktfx.coroutines

import com.hanggrian.ktfx.test.testScene
import javafx.scene.media.Media
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertTrue

class MediaTest : ApplicationTest() {
    private lateinit var media: Media

    override fun start(stage: Stage) {
        stage.testScene<Media>()
        media = Media(javaClass.classLoader.getResource("sample.mp3")!!.toString())
    }

    @Test
    fun onError() {
        var assigned = false
        interact {
            media.onError {
                assigned = true
            }
            media.onError.run()
        }
        assertTrue(assigned)
    }
}
