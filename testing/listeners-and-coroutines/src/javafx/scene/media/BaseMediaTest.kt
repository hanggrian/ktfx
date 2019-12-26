package ktfx.test

import javafx.scene.media.Media
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

abstract class BaseMediaTest {
    private lateinit var media: Media

    abstract fun Media.callOnError(action: () -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        media = Media(javaClass.classLoader.getResource("sample.flv")!!.toString())
    }

    @Test fun onError() {
        var isCalled = false
        media.callOnError { assertTrue(isCalled) }
        isCalled = true
        media.onError.run()
    }
}