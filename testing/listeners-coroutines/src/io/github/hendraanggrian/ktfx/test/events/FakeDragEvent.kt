package io.github.hendraanggrian.ktfx.test

import javafx.event.EventType
import javafx.scene.input.DragEvent
import javafx.scene.input.TransferMode
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * @receiver source of this fake event.
 */
fun Any.assertFakeDragEvent(actual: DragEvent, expectedType: EventType<DragEvent>) {
    assertEquals(this, actual.source)
    assertEquals(FakeEventTarget, actual.target)
    assertEquals(expectedType, actual.eventType)
    assertNull(actual.dragboard)
    assertEquals(0.0, actual.x)
    assertEquals(0.0, actual.y)
    assertEquals(0.0, actual.sceneX)
    assertEquals(0.0, actual.sceneY)
    assertEquals(TransferMode.MOVE, actual.transferMode)
    assertNull(actual.gestureSource)
    assertNull(actual.gestureTarget)
    assertEquals(FakePickResult, actual.pickResult)
}

/**
 * @receiver source of this fake event.
 */
fun Any.fakeDragEventOf(eventType: EventType<DragEvent>) = DragEvent(
    this, FakeEventTarget, eventType, null,
    0.0, 0.0,
    0.0, 0.0, TransferMode.MOVE,
    null, null, FakePickResult
)