package com.hanggrian.ktfx.test.events

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.FakePickResult
import javafx.event.EventType
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseDragEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeMouseDragEvent(actual: MouseDragEvent, expectedType: EventType<MouseDragEvent>) {
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
    assertEquals(FakePickResult, actual.pickResult)
    assertNull(actual.gestureSource)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeMouseDragEventOf(eventType: EventType<MouseDragEvent>) =
    MouseDragEvent(
        this,
        FakeEventTarget,
        eventType,
        0.0,
        0.0,
        0.0,
        0.0,
        MouseButton.PRIMARY,
        1,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        false,
        FakePickResult,
        null,
    )
