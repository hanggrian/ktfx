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
import javafx.scene.Scene
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
import javafx.scene.layout.Pane
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class SceneTest {
    private lateinit var scene: Scene

    @BeforeTest
    fun onCreate() {
        initToolkit()
        scene = Scene(Pane())
    }

    @Test
    fun onMouseClicked() {
        scene.onMouseClicked(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_CLICKED)
        }
        scene.onMouseClicked.handle(fakeMouseEventOf(MouseEvent.MOUSE_CLICKED))
    }

    @Test
    fun onMouseDragged() {
        scene.onMouseDragged(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_DRAGGED)
        }
        scene.onMouseDragged.handle(fakeMouseEventOf(MouseEvent.MOUSE_DRAGGED))
    }

    @Test
    fun onMouseEntered() {
        scene.onMouseEntered(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_ENTERED)
        }
        scene.onMouseEntered.handle(fakeMouseEventOf(MouseEvent.MOUSE_ENTERED))
    }

    @Test
    fun onMouseExited() {
        scene.onMouseExited(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_EXITED)
        }
        scene.onMouseExited.handle(fakeMouseEventOf(MouseEvent.MOUSE_EXITED))
    }

    @Test
    fun onMouseMoved() {
        scene.onMouseMoved(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_MOVED)
        }
        scene.onMouseMoved.handle(fakeMouseEventOf(MouseEvent.MOUSE_MOVED))
    }

    @Test
    fun onMousePressed() {
        scene.onMousePressed(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_PRESSED)
        }
        scene.onMousePressed.handle(fakeMouseEventOf(MouseEvent.MOUSE_PRESSED))
    }

    @Test
    fun onMouseReleased() {
        scene.onMouseReleased(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.MOUSE_RELEASED)
        }
        scene.onMouseReleased.handle(fakeMouseEventOf(MouseEvent.MOUSE_RELEASED))
    }

    @Test
    fun onDragDetected() {
        scene.onDragDetected(Dispatchers.Unconfined) {
            assertFakeMouseEvent(it, MouseEvent.DRAG_DETECTED)
        }
        scene.onDragDetected.handle(fakeMouseEventOf(MouseEvent.DRAG_DETECTED))
    }

    @Test
    fun onMouseDragOver() {
        scene.onMouseDragOver(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_OVER)
        }
        scene.onMouseDragOver.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_OVER))
    }

    @Test
    fun onMouseDragReleased() {
        scene.onMouseDragReleased(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_RELEASED)
        }
        scene.onMouseDragReleased.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_RELEASED))
    }

    @Test
    fun onMouseDragEntered() {
        scene.onMouseDragEntered(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_ENTERED)
        }
        scene.onMouseDragEntered.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_ENTERED))
    }

    @Test
    fun onMouseDragExited() {
        scene.onMouseDragExited(Dispatchers.Unconfined) {
            assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_EXITED)
        }
        scene.onMouseDragExited.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_EXITED))
    }

    @Test
    fun onScrollStarted() {
        scene.onScrollStarted(Dispatchers.Unconfined) {
            assertFakeScrollEvent(it, ScrollEvent.SCROLL_STARTED)
        }
        scene.onScrollStarted.handle(fakeScrollEventOf(ScrollEvent.SCROLL_STARTED))
    }

    @Test
    fun onScroll() {
        scene.onScroll(Dispatchers.Unconfined) {
            assertFakeScrollEvent(it, ScrollEvent.SCROLL)
        }
        scene.onScroll.handle(fakeScrollEventOf(ScrollEvent.SCROLL))
    }

    @Test
    fun onScrollFinished() {
        scene.onScrollFinished(Dispatchers.Unconfined) {
            assertFakeScrollEvent(it, ScrollEvent.SCROLL_FINISHED)
        }
        scene.onScrollFinished.handle(fakeScrollEventOf(ScrollEvent.SCROLL_FINISHED))
    }

    @Test
    fun onRotateStarted() {
        scene.onRotationStarted(Dispatchers.Unconfined) {
            assertFakeRotateEvent(it, RotateEvent.ROTATION_STARTED)
        }
        scene.onRotationStarted.handle(fakeRotateEventOf(RotateEvent.ROTATION_STARTED))
    }

    @Test
    fun onRotate() {
        scene.onRotate(Dispatchers.Unconfined) {
            assertFakeRotateEvent(it, RotateEvent.ROTATE)
        }
        scene.onRotate.handle(fakeRotateEventOf(RotateEvent.ROTATE))
    }

    @Test
    fun onRotateFinished() {
        scene.onRotationFinished(Dispatchers.Unconfined) {
            assertFakeRotateEvent(it, RotateEvent.ROTATION_FINISHED)
        }
        scene.onRotationFinished.handle(fakeRotateEventOf(RotateEvent.ROTATION_FINISHED))
    }

    @Test
    fun onZoomStarted() {
        scene.onZoomStarted(Dispatchers.Unconfined) {
            assertFakeZoomEvent(it, ZoomEvent.ZOOM_STARTED)
        }
        scene.onZoomStarted.handle(fakeZoomEventOf(ZoomEvent.ZOOM_STARTED))
    }

    @Test
    fun onZoom() {
        scene.onZoom(Dispatchers.Unconfined) {
            assertFakeZoomEvent(it, ZoomEvent.ZOOM)
        }
        scene.onZoom.handle(fakeZoomEventOf(ZoomEvent.ZOOM))
    }

    @Test
    fun onZoomFinished() {
        scene.onZoomFinished(Dispatchers.Unconfined) {
            assertFakeZoomEvent(it, ZoomEvent.ZOOM_FINISHED)
        }
        scene.onZoomFinished.handle(fakeZoomEventOf(ZoomEvent.ZOOM_FINISHED))
    }

    @Test
    fun onSwipeUp() {
        scene.onSwipeUp(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_UP)
        }
        scene.onSwipeUp.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_UP))
    }

    @Test
    fun onSwipeDown() {
        scene.onSwipeDown(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_DOWN)
        }
        scene.onSwipeDown.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_DOWN))
    }

    @Test
    fun onSwipeRight() {
        scene.onSwipeRight(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_RIGHT)
        }
        scene.onSwipeRight.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_RIGHT))
    }

    @Test
    fun onSwipeLeft() {
        scene.onSwipeLeft(Dispatchers.Unconfined) {
            assertFakeSwipeEvent(it, SwipeEvent.SWIPE_LEFT)
        }
        scene.onSwipeLeft.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_LEFT))
    }

    @Test
    fun onTouchPressed() {
        scene.onTouchPressed(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_PRESSED)
        }
        scene.onTouchPressed.handle(fakeTouchEventOf(TouchEvent.TOUCH_PRESSED))
    }

    @Test
    fun onTouchMoved() {
        scene.onTouchMoved(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_MOVED)
        }
        scene.onTouchMoved.handle(fakeTouchEventOf(TouchEvent.TOUCH_MOVED))
    }

    @Test
    fun onTouchReleased() {
        scene.onTouchReleased(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_RELEASED)
        }
        scene.onTouchReleased.handle(fakeTouchEventOf(TouchEvent.TOUCH_RELEASED))
    }

    @Test
    fun onTouchStationary() {
        scene.onTouchStationary(Dispatchers.Unconfined) {
            assertFakeTouchEvent(it, TouchEvent.TOUCH_STATIONARY)
        }
        scene.onTouchStationary.handle(fakeTouchEventOf(TouchEvent.TOUCH_STATIONARY))
    }

    @Test
    fun onDragEntered() {
        scene.onDragEntered(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_ENTERED)
        }
        scene.onDragEntered.handle(fakeDragEventOf(DragEvent.DRAG_ENTERED))
    }

    @Test
    fun onDragExited() {
        scene.onDragExited(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_EXITED)
        }
        scene.onDragExited.handle(fakeDragEventOf(DragEvent.DRAG_EXITED))
    }

    @Test
    fun onDragOver() {
        scene.onDragOver(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_OVER)
        }
        scene.onDragOver.handle(fakeDragEventOf(DragEvent.DRAG_OVER))
    }

    @Test
    fun onDragDropped() {
        scene.onDragDropped(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_DROPPED)
        }
        scene.onDragDropped.handle(fakeDragEventOf(DragEvent.DRAG_DROPPED))
    }

    @Test
    fun onDragDone() {
        scene.onDragDone(Dispatchers.Unconfined) {
            assertFakeDragEvent(it, DragEvent.DRAG_DONE)
        }
        scene.onDragDone.handle(fakeDragEventOf(DragEvent.DRAG_DONE))
    }

    @Test
    fun onKeyPressed() {
        scene.onKeyPressed(Dispatchers.Unconfined) {
            assertFakeKeyEvent(it, KeyEvent.KEY_PRESSED)
        }
        scene.onKeyPressed.handle(fakeKeyEventOf(KeyEvent.KEY_PRESSED))
    }

    @Test
    fun onKeyReleased() {
        scene.onKeyReleased(Dispatchers.Unconfined) {
            assertFakeKeyEvent(it, KeyEvent.KEY_RELEASED)
        }
        scene.onKeyReleased.handle(fakeKeyEventOf(KeyEvent.KEY_RELEASED))
    }

    @Test
    fun onKeyTyped() {
        scene.onKeyTyped(Dispatchers.Unconfined) {
            assertFakeKeyEvent(it, KeyEvent.KEY_TYPED)
        }
        scene.onKeyTyped.handle(fakeKeyEventOf(KeyEvent.KEY_TYPED))
    }

    @Test
    fun onInputMethodTextChanged() {
        scene.onInputMethodTextChanged(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(InputMethodEvent.INPUT_METHOD_TEXT_CHANGED, it.eventType)
            assertThat(it.composed).isEmpty()
            assertEquals("Hello world", it.committed)
            assertEquals(0, it.caretPosition)
        }
        scene.onInputMethodTextChanged.handle(
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

    @Test
    fun onContextMenuRequested() {
        scene.onContextMenuRequested(Dispatchers.Unconfined) {
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
        scene.onContextMenuRequested.handle(
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
}
