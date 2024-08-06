package ktfx.coroutines

import com.google.common.truth.Truth.assertThat
import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.FakePickResult
import com.hanggrian.ktfx.test.events.assertFakeDragEvent
import com.hanggrian.ktfx.test.events.assertFakeKeyEvent
import com.hanggrian.ktfx.test.events.assertFakeMouseDragEvent
import com.hanggrian.ktfx.test.events.assertFakeMouseEvent
import com.hanggrian.ktfx.test.events.assertFakeRotateEvent
import com.hanggrian.ktfx.test.events.assertFakeScrollEvent
import com.hanggrian.ktfx.test.events.assertFakeSwipeEvent
import com.hanggrian.ktfx.test.events.assertFakeTouchEvent
import com.hanggrian.ktfx.test.events.assertFakeZoomEvent
import com.hanggrian.ktfx.test.events.fakeDragEventOf
import com.hanggrian.ktfx.test.events.fakeKeyEventOf
import com.hanggrian.ktfx.test.events.fakeMouseDragEventOf
import com.hanggrian.ktfx.test.events.fakeMouseEventOf
import com.hanggrian.ktfx.test.events.fakeRotateEventOf
import com.hanggrian.ktfx.test.events.fakeScrollEventOf
import com.hanggrian.ktfx.test.events.fakeSwipeEventOf
import com.hanggrian.ktfx.test.events.fakeTouchEventOf
import com.hanggrian.ktfx.test.events.fakeZoomEventOf
import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.Label
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.MouseEvent
import javafx.scene.input.RotateEvent
import javafx.scene.input.ScrollEvent
import javafx.scene.input.SwipeEvent
import javafx.scene.input.TouchEvent
import javafx.scene.input.ZoomEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class NodeTest {
    private lateinit var node: Label

    @BeforeTest
    fun onCreate() {
        initToolkit()
        node = Label()
    }

    @Test
    fun onDragEntered() {
        node.onDragEntered(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_ENTERED)
        }
        node.onDragEntered.handle(fakeDragEventOf(DragEvent.DRAG_ENTERED))
    }

    @Test
    fun onDragExited() {
        node.onDragExited(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_EXITED)
        }
        node.onDragExited.handle(fakeDragEventOf(DragEvent.DRAG_EXITED))
    }

    @Test
    fun onDragOver() {
        node.onDragOver(Dispatchers.Unconfined) { assertFakeDragEvent(it, DragEvent.DRAG_OVER) }
        node.onDragOver.handle(fakeDragEventOf(DragEvent.DRAG_OVER))
    }

    @Test
    fun onDragDropped() {
        node.onDragDropped(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_DROPPED)
        }
        node.onDragDropped.handle(fakeDragEventOf(DragEvent.DRAG_DROPPED))
    }

    @Test
    fun onDragDone() {
        node.onDragDone(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_DONE)
        }
        node.onDragDone.handle(fakeDragEventOf(DragEvent.DRAG_DONE))
    }

    @Test
    fun onContextMenuRequested() {
        node.onContextMenuRequested(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ContextMenuEvent.CONTEXT_MENU_REQUESTED, it.eventType)
            assertEquals(0.0, it.x)
            assertEquals(0.0, it.y)
            assertEquals(0.0, it.sceneX)
            assertEquals(0.0, it.sceneY)
            assertFalse(it.isKeyboardTrigger)
            assertEquals(FakePickResult, it.pickResult)
        }
        node.onContextMenuRequested.handle(
            ContextMenuEvent(
                this,
                FakeEventTarget,
                ContextMenuEvent.CONTEXT_MENU_REQUESTED,
                0.0,
                0.0,
                0.0,
                0.0,
                false,
                FakePickResult,
            ),
        )
    }

    @Test
    fun onMouseClicked() {
        node.onMouseClicked(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_CLICKED)
        }
        node.onMouseClicked.handle(fakeMouseEventOf(MouseEvent.MOUSE_CLICKED))
    }

    @Test
    fun onMouseDragged() {
        node.onMouseDragged(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_DRAGGED)
        }
        node.onMouseDragged.handle(fakeMouseEventOf(MouseEvent.MOUSE_DRAGGED))
    }

    @Test
    fun onMouseEntered() {
        node.onMouseEntered(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_ENTERED)
        }
        node.onMouseEntered.handle(fakeMouseEventOf(MouseEvent.MOUSE_ENTERED))
    }

    @Test
    fun onMouseExited() {
        node.onMouseExited(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_EXITED)
        }
        node.onMouseExited.handle(fakeMouseEventOf(MouseEvent.MOUSE_EXITED))
    }

    @Test
    fun onMouseMoved() {
        node.onMouseMoved(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_MOVED)
        }
        node.onMouseMoved.handle(fakeMouseEventOf(MouseEvent.MOUSE_MOVED))
    }

    @Test
    fun onMousePressed() {
        node.onMousePressed(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_PRESSED)
        }
        node.onMousePressed.handle(fakeMouseEventOf(MouseEvent.MOUSE_PRESSED))
    }

    @Test
    fun onMouseReleased() {
        node.onMouseReleased(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_RELEASED)
        }
        node.onMouseReleased.handle(fakeMouseEventOf(MouseEvent.MOUSE_RELEASED))
    }

    @Test
    fun onDragDetected() {
        node.onDragDetected(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.DRAG_DETECTED)
        }
        node.onDragDetected.handle(fakeMouseEventOf(MouseEvent.DRAG_DETECTED))
    }

    @Test
    fun onMouseDragOver() {
        node.onMouseDragOver(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_OVER)
        }
        node.onMouseDragOver.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_OVER))
    }

    @Test
    fun onMouseDragReleased() {
        node.onMouseDragReleased(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_RELEASED)
        }
        node.onMouseDragReleased.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_RELEASED))
    }

    @Test
    fun onMouseDragEntered() {
        node.onMouseDragEntered(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_ENTERED)
        }
        node.onMouseDragEntered.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_ENTERED))
    }

    @Test
    fun onMouseDragExited() {
        node.onMouseDragExited(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_EXITED)
        }
        node.onMouseDragExited.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_EXITED))
    }

    @Test
    fun onScrollStarted() {
        node.onScrollStarted(Dispatchers.Unconfined) {
            assertFakeScrollEvent(it, ScrollEvent.SCROLL_STARTED)
        }
        node.onScrollStarted.handle(fakeScrollEventOf(ScrollEvent.SCROLL_STARTED))
    }

    @Test
    fun onScroll() {
        node.onScroll(Dispatchers.Unconfined) {
            assertFakeScrollEvent(it, ScrollEvent.SCROLL)
        }
        node.onScroll.handle(fakeScrollEventOf(ScrollEvent.SCROLL))
    }

    @Test
    fun onScrollFinished() {
        node.onScrollFinished(Dispatchers.Unconfined) {
            assertFakeScrollEvent(it, ScrollEvent.SCROLL_FINISHED)
        }
        node.onScrollFinished.handle(fakeScrollEventOf(ScrollEvent.SCROLL_FINISHED))
    }

    @Test
    fun onRotateStarted() {
        node.onRotationStarted(Dispatchers.Unconfined) {
            assertFakeRotateEvent(it, RotateEvent.ROTATION_STARTED)
        }
        node.onRotationStarted.handle(fakeRotateEventOf(RotateEvent.ROTATION_STARTED))
    }

    @Test
    fun onRotate() {
        node.onRotate(Dispatchers.Unconfined) {
            assertFakeRotateEvent(it, RotateEvent.ROTATE)
        }
        node.onRotate.handle(fakeRotateEventOf(RotateEvent.ROTATE))
    }

    @Test
    fun onRotateFinished() {
        node.onRotationFinished(Dispatchers.Unconfined) {
            assertFakeRotateEvent(it, RotateEvent.ROTATION_FINISHED)
        }
        node.onRotationFinished.handle(fakeRotateEventOf(RotateEvent.ROTATION_FINISHED))
    }

    @Test
    fun onZoomStarted() {
        node.onZoomStarted(Dispatchers.Unconfined) {
            assertFakeZoomEvent(it, ZoomEvent.ZOOM_STARTED)
        }
        node.onZoomStarted.handle(fakeZoomEventOf(ZoomEvent.ZOOM_STARTED))
    }

    @Test
    fun onZoom() {
        node.onZoom(Dispatchers.Unconfined) {
            assertFakeZoomEvent(it, ZoomEvent.ZOOM)
        }
        node.onZoom.handle(fakeZoomEventOf(ZoomEvent.ZOOM))
    }

    @Test
    fun onZoomFinished() {
        node.onZoomFinished(Dispatchers.Unconfined) {
            assertFakeZoomEvent(it, ZoomEvent.ZOOM_FINISHED)
        }
        node.onZoomFinished.handle(fakeZoomEventOf(ZoomEvent.ZOOM_FINISHED))
    }

    @Test
    fun onSwipeUp() {
        node.onSwipeUp(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_UP)
        }
        node.onSwipeUp.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_UP))
    }

    @Test
    fun onSwipeDown() {
        node.onSwipeDown(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_DOWN)
        }
        node.onSwipeDown.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_DOWN))
    }

    @Test
    fun onSwipeRight() {
        node.onSwipeRight(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_RIGHT)
        }
        node.onSwipeRight.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_RIGHT))
    }

    @Test
    fun onSwipeLeft() {
        node.onSwipeLeft(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_LEFT)
        }
        node.onSwipeLeft.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_LEFT))
    }

    @Test
    fun onTouchPressed() {
        node.onTouchPressed(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_PRESSED)
        }
        node.onTouchPressed.handle(fakeTouchEventOf(TouchEvent.TOUCH_PRESSED))
    }

    @Test
    fun onTouchMoved() {
        node.onTouchMoved(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_MOVED)
        }
        node.onTouchMoved.handle(fakeTouchEventOf(TouchEvent.TOUCH_MOVED))
    }

    @Test
    fun onTouchReleased() {
        node.onTouchReleased(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_RELEASED)
        }
        node.onTouchReleased.handle(fakeTouchEventOf(TouchEvent.TOUCH_RELEASED))
    }

    @Test
    fun onTouchStationary() {
        node.onTouchStationary(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_STATIONARY)
        }
        node.onTouchStationary.handle(fakeTouchEventOf(TouchEvent.TOUCH_STATIONARY))
    }

    @Test
    fun onKeyPressed() {
        node.onKeyPressed(Dispatchers.Unconfined) {
            assertFakeKeyEvent(it, KeyEvent.KEY_PRESSED)
        }
        node.onKeyPressed.handle(fakeKeyEventOf(KeyEvent.KEY_PRESSED))
    }

    @Test
    fun onKeyReleased() {
        node.onKeyReleased(Dispatchers.Unconfined) {
            assertFakeKeyEvent(it, KeyEvent.KEY_RELEASED)
        }
        node.onKeyReleased.handle(fakeKeyEventOf(KeyEvent.KEY_RELEASED))
    }

    @Test
    fun onKeyTyped() {
        node.onKeyTyped(Dispatchers.Unconfined) {
            assertFakeKeyEvent(it, KeyEvent.KEY_TYPED)
        }
        node.onKeyTyped.handle(fakeKeyEventOf(KeyEvent.KEY_TYPED))
    }

    @Test
    fun onInputMethodTextChanged() {
        node.onInputMethodTextChanged(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(InputMethodEvent.INPUT_METHOD_TEXT_CHANGED, it.eventType)
            assertThat(it.composed).isEmpty()
            assertEquals("Hello world", it.committed)
            assertEquals(0, it.caretPosition)
        }
        node.onInputMethodTextChanged.handle(
            InputMethodEvent(
                this,
                FakeEventTarget,
                InputMethodEvent.INPUT_METHOD_TEXT_CHANGED,
                listOf(),
                "Hello world",
                0,
            ),
        )
    }
}
