package com.hanggrian.ktfx.test.events

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.FakePickResult
import javafx.event.EventType
import javafx.scene.input.RotateEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeRotateEvent(actual: RotateEvent, expectedType: EventType<RotateEvent>) {
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
    assertEquals(0.0, actual.angle)
    assertEquals(0.0, actual.totalAngle)
    assertEquals(FakePickResult, actual.pickResult)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeRotateEventOf(eventType: EventType<RotateEvent>) =
    RotateEvent(
        this,
        FakeEventTarget,
        eventType,
        0.0,
        0.0,
        0.0,
        0.0,
        false,
        false,
        false,
        false,
        false,
        false,
        0.0,
        0.0,
        FakePickResult,
    )
