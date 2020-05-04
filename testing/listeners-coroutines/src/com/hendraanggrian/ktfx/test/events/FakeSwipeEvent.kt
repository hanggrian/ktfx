package com.hendraanggrian.ktfx.test

import javafx.event.EventType
import javafx.scene.input.SwipeEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeSwipeEvent(actual: SwipeEvent, expectedType: EventType<SwipeEvent>) {
    assertEquals(this, actual.source)
    assertEquals(FakeEventTarget, actual.target)
    assertEquals(expectedType, actual.eventType)
    assertEquals(0.0, actual.x)
    assertEquals(0.0, actual.y)
    assertEquals(0.0, actual.screenX)
    assertEquals(0.0, actual.screenY)
    assertFalse(actual.isShiftDown)
    assertFalse(actual.isControlDown)
    assertFalse(actual.isAltDown)
    assertFalse(actual.isMetaDown)
    assertFalse(actual.isDirect)
    assertEquals(0, actual.touchCount)
    assertEquals(FakePickResult, actual.pickResult)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeSwipeEventOf(eventType: EventType<SwipeEvent>) = SwipeEvent(
    this, FakeEventTarget, eventType,
    0.0, 0.0,
    0.0, 0.0,
    false,
    false,
    false,
    false,
    false,
    0,
    FakePickResult
)