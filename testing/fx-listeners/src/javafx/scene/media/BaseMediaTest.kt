package ktfx.test

import javafx.scene.media.Media
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

abstract class BaseMediaTest {

    abstract fun Media.callOnError(action: () -> Unit)

    private lateinit var media: Media

    @BeforeTest fun start() {
        initToolkit()
        media = Media("file:sample.flv")
    }

    @Test fun onError() {
        var isCalled = false
        media.callOnError { assertTrue(isCalled) }
        isCalled = true
        media.onError.run()
    }
}