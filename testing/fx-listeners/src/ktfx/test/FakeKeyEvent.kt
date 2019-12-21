package ktfx.test

import javafx.event.EventType
import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse

fun assertFakeKeyEvent(source: Any, actual: KeyEvent, expectedType: EventType<KeyEvent>) {
    assertEquals(source, actual.source)
    assertEquals(FakeEventTarget, actual.target)
    assertEquals(expectedType, actual.eventType)
    assertEquals("A", actual.character)
    assertEquals("Hello world", actual.text)
    assertEquals(KeyCode.A, actual.code)
    assertFalse(actual.isShiftDown)
    assertFalse(actual.isControlDown)
    assertFalse(actual.isAltDown)
    assertFalse(actual.isMetaDown)
}

fun fakeKeyEventOf(source: Any, eventType: EventType<KeyEvent>) = KeyEvent(
    source, FakeEventTarget, eventType, "A", "Hello world", KeyCode.A,
    false, false, false, false
)