package ktfx.test

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import javafx.scene.media.assertFakeMediaErrorEvent
import javafx.scene.media.fakeMediaErrorEventOf
import kotlin.test.BeforeTest
import kotlin.test.Test

abstract class BaseMediaViewTest {

    abstract fun MediaView.callOnError(action: (MediaErrorEvent) -> Unit)

    private lateinit var media: MediaView

    @BeforeTest fun start() {
        initToolkit()
        media = MediaView()
    }

    @Test fun onError() {
        media.callOnError { assertFakeMediaErrorEvent(it) }
        media.onError.handle(fakeMediaErrorEventOf())
    }
}