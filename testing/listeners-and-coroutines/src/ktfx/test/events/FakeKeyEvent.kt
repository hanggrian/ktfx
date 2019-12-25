package ktfx.test

import javafx.event.EventType
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeKeyEvent(actual: KeyEvent, expectedType: EventType<KeyEvent>) {
    assertEquals(this, actual.source)
    assertEquals(FakeEventTarget, actual.target)
    assertEquals(expectedType, actual.eventType)
    // assertEquals("", actual.character) // unstable
    // assertEquals("Hello world", actual.text) // unstable
    // assertEquals(KeyCode.A, actual.code) // unstable
    assertFalse(actual.isShiftDown)
    assertFalse(actual.isControlDown)
    assertFalse(actual.isAltDown)
    assertFalse(actual.isMetaDown)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeKeyEventOf(eventType: EventType<KeyEvent>) = KeyEvent(
    this, FakeEventTarget, eventType, "",
    "Hello world", KeyCode.A, false, false,
    false, false
)