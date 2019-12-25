package javafx.scene.media

import ktfx.test.FakeEventTarget
import kotlin.test.assertEquals

private val MEDIA_EXCEPTION = MediaException(MediaException.Type.MEDIA_UNAVAILABLE, "Unavailable")

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeMediaErrorEvent(actual: MediaErrorEvent) {
    assertEquals(this, actual.source)
    assertEquals(FakeEventTarget, actual.target)
    assertEquals(MEDIA_EXCEPTION, actual.mediaError)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeMediaErrorEventOf() = MediaErrorEvent(this, FakeEventTarget, MEDIA_EXCEPTION)