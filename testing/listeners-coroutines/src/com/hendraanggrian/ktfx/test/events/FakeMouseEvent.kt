package com.hendraanggrian.ktfx.test

import javafx.event.EventType
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeMouseEvent(actual: MouseEvent, expectedType: EventType<MouseEvent>) {
    assertEquals(this, actual.source)
    assertEquals(FakeEventTarget, actual.target)
    assertEquals(expectedType, actual.eventType)
    assertEquals(0.0, actual.x)
    assertEquals(0.0, actual.y)
    assertEquals(0.0, actual.sceneX)
    assertEquals(0.0, actual.sceneY)
    assertFalse(actual.isShiftDown)
    assertFalse(actual.isControlDown)
    assertFalse(actual.isAltDown)
    assertFalse(actual.isMetaDown)
    assertFalse(actual.isPrimaryButtonDown)
    assertFalse(actual.isMiddleButtonDown)
    assertFalse(actual.isSecondaryButtonDown)
    assertFalse(actual.isSynthesized)
    assertFalse(actual.isPopupTrigger)
    assertFalse(actual.isStillSincePress)
    assertEquals(FakePickResult, actual.pickResult)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeMouseEventOf(eventType: EventType<MouseEvent>) = MouseEvent(
    this, FakeEventTarget,
    eventType,
    0.0, 0.0,
    0.0, 0.0,
    MouseButton.PRIMARY, 1,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    false,
    FakePickResult
)
