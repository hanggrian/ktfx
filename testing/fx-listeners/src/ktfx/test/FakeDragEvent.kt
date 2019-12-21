package ktfx.test

import javafx.event.EventType
import javafx.scene.input.DragEvent
import javafx.scene.input.TransferMode
import kotlin.test.assertEquals
import kotlin.test.assertNull

fun assertFakeDragEvent(source: Any, actual: DragEvent, expectedType: EventType<DragEvent>) {
    assertEquals(source, actual.source)
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

fun fakeDragEventOf(source: Any, eventType: EventType<DragEvent>) = DragEvent(
    source, FakeEventTarget, eventType, null,
    0.0, 0.0, 0.0, 0.0,
    TransferMode.MOVE, null, null, FakePickResult
)