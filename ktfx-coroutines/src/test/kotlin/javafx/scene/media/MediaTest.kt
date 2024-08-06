package ktfx.coroutines

import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.media.Media
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Ignore
import kotlin.test.Test
import kotlin.test.assertTrue

@Ignore
class MediaTest {
    private lateinit var media: Media

    @BeforeTest
    fun start() {
        initToolkit()
        media = Media(javaClass.classLoader.getResource("sample.flv")!!.toString())
    }

    @Test
    fun onError() {
        var isCalled = false
        media.onError(Dispatchers.Unconfined) { assertTrue(isCalled) }
        isCalled = true
        media.onError.run()
    }
}
