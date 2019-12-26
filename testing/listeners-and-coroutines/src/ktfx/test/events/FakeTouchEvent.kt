package ktfx.test

import com.google.common.truth.Truth.assertThat
import javafx.event.EventType
import javafx.scene.input.TouchEvent
import javafx.scene.input.TouchPoint
import kotlin.test.assertEquals
import kotlin.test.assertFalse

private val touchPoint = TouchPoint(
    0, TouchPoint.State.MOVED, 0.0, 0.0, 0.0,
    0.0, FakeEventTarget, FakePickResult
)

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeTouchEvent(actual: TouchEvent, expectedType: EventType<TouchEvent>) {
    assertEquals(this, actual.source)
    assertEquals(FakeEventTarget, actual.target)
    assertEquals(expectedType, actual.eventType)
    assertEquals(touchPoint, actual.touchPoint)
    assertThat(actual.touchPoints).isEmpty()
    assertEquals(0, actual.eventSetId)
    assertFalse(actual.isShiftDown)
    assertFalse(actual.isControlDown)
    assertFalse(actual.isAltDown)
    assertFalse(actual.isMetaDown)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeTouchEventOf(eventType: EventType<TouchEvent>) = TouchEvent(
    this, FakeEventTarget, eventType,
    touchPoint, listOf<TouchPoint>(), 0,
    false, false, false,
    false
)