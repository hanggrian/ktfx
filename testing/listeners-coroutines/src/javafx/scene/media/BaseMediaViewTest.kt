package io.github.hendraanggrian.ktfx.test

import javafx.scene.media.MediaErrorEvent
import javafx.scene.media.MediaView
import kotlin.test.BeforeTest
import kotlin.test.Test

abstract class BaseMediaViewTest {
    private lateinit var media: MediaView

    abstract fun MediaView.callOnError(action: (MediaErrorEvent) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        media = MediaView()
    }

    @Test fun onError() {
        // TODO: create fake event
        // media.callOnError { assertFakeMediaErrorEvent(it) }
        // media.onError.handle(fakeMediaErrorEventOf())
    }
}