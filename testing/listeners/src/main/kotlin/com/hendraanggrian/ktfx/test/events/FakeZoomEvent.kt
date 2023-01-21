package com.hendraanggrian.ktfx.test

import javafx.event.EventType
import javafx.scene.input.ZoomEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeZoomEvent(actual: ZoomEvent, expectedType: EventType<ZoomEvent>) {
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
    assertFalse(actual.isInertia)
    assertEquals(0.0, actual.zoomFactor)
    assertEquals(0.0, actual.totalZoomFactor)
    assertEquals(FakePickResult, actual.pickResult)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeZoomEventOf(eventType: EventType<ZoomEvent>) = ZoomEvent(
    this, FakeEventTarget, eventType,
    0.0, 0.0,
    0.0, 0.0,
    false,
    false,
    false,
    false,
    false,
    false,
    0.0,
    0.0,
    FakePickResult
)
