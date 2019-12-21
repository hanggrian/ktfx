package ktfx.test

import javafx.event.EventType
import javafx.scene.input.MouseButton
import javafx.scene.input.MouseDragEvent
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNull

fun assertFakeMouseDragEvent(source: Any, actual: MouseDragEvent, expectedType: EventType<MouseDragEvent>) {
    assertEquals(source, actual.source)
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

fun fakeMouseDragEventOf(source: Any, eventType: EventType<MouseDragEvent>) = MouseDragEvent(
    source, FakeEventTarget, eventType,
    0.0, 0.0, 0.0, 0.0,
    MouseButton.PRIMARY, 1,
    false, false, false, false, false, false, false, false, false,
    FakePickResult, null
)