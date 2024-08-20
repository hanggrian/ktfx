package com.hanggrian.ktfx.test.events

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.FakePickResult
import javafx.event.EventType
import javafx.scene.input.ScrollEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeScrollEvent(actual: ScrollEvent, expectedType: EventType<ScrollEvent>) {
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
    assertEquals(0.0, actual.deltaX)
    assertEquals(0.0, actual.deltaY)
    assertEquals(0.0, actual.totalDeltaX)
    assertEquals(0.0, actual.totalDeltaY)
    assertEquals(ScrollEvent.HorizontalTextScrollUnits.CHARACTERS, actual.textDeltaXUnits)
    assertEquals(ScrollEvent.VerticalTextScrollUnits.LINES, actual.textDeltaYUnits)
    assertEquals(0, actual.touchCount)
    assertEquals(FakePickResult, actual.pickResult)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeScrollEventOf(eventType: EventType<ScrollEvent>) =
    ScrollEvent(
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
        0.0,
        0.0,
        ScrollEvent.HorizontalTextScrollUnits.CHARACTERS,
        0.0,
        ScrollEvent.VerticalTextScrollUnits.LINES,
        0.0,
        0,
        FakePickResult,
    )
