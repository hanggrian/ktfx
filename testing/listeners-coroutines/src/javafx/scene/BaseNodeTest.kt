package ktfx.test

import com.google.common.truth.Truth.assertThat
import javafx.scene.Node
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
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

abstract class BaseNodeTest {
    private lateinit var node: Label

    abstract fun Node.callOnDragEntered(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragExited(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragOver(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragDropped(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragDone(action: (DragEvent) -> Unit)
    abstract fun Node.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit)
    abstract fun Node.callOnMouseClicked(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMouseDragged(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMouseEntered(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMouseExited(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMouseMoved(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMousePressed(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMouseReleased(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnDragDetected(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMouseDragOver(action: (MouseDragEvent) -> Unit)
    abstract fun Node.callOnMouseDragReleased(action: (MouseDragEvent) -> Unit)
    abstract fun Node.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit)
    abstract fun Node.callOnMouseDragExited(action: (MouseDragEvent) -> Unit)
    abstract fun Node.callOnScrollStarted(action: (ScrollEvent) -> Unit)
    abstract fun Node.callOnScroll(action: (ScrollEvent) -> Unit)
    abstract fun Node.callOnScrollFinished(action: (ScrollEvent) -> Unit)
    abstract fun Node.callOnRotateStarted(action: (RotateEvent) -> Unit)
    abstract fun Node.callOnRotate(action: (RotateEvent) -> Unit)
    abstract fun Node.callOnRotateFinished(action: (RotateEvent) -> Unit)
    abstract fun Node.callOnZoomStarted(action: (ZoomEvent) -> Unit)
    abstract fun Node.callOnZoom(action: (ZoomEvent) -> Unit)
    abstract fun Node.callOnZoomFinished(action: (ZoomEvent) -> Unit)
    abstract fun Node.callOnSwipeUp(action: (SwipeEvent) -> Unit)
    abstract fun Node.callOnSwipeDown(action: (SwipeEvent) -> Unit)
    abstract fun Node.callOnSwipeLeft(action: (SwipeEvent) -> Unit)
    abstract fun Node.callOnSwipeRight(action: (SwipeEvent) -> Unit)
    abstract fun Node.callOnTouchPressed(action: (TouchEvent) -> Unit)
    abstract fun Node.callOnTouchMoved(action: (TouchEvent) -> Unit)
    abstract fun Node.callOnTouchReleased(action: (TouchEvent) -> Unit)
    abstract fun Node.callOnTouchStationary(action: (TouchEvent) -> Unit)
    abstract fun Node.callOnKeyPressed(action: (KeyEvent) -> Unit)
    abstract fun Node.callOnKeyReleased(action: (KeyEvent) -> Unit)
    abstract fun Node.callOnKeyTyped(action: (KeyEvent) -> Unit)
    abstract fun Node.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit)

    @BeforeTest fun onCreate() {
        initToolkit()
        node = Label()
    }

    @Test fun onDragEntered() {
        node.callOnDragEntered { assertFakeDragEvent(it, DragEvent.DRAG_ENTERED) }
        node.onDragEntered.handle(fakeDragEventOf(DragEvent.DRAG_ENTERED))
    }

    @Test fun onDragExited() {
        node.callOnDragExited { assertFakeDragEvent(it, DragEvent.DRAG_EXITED) }
        node.onDragExited.handle(fakeDragEventOf(DragEvent.DRAG_EXITED))
    }

    @Test fun onDragOver() {
        node.callOnDragOver { assertFakeDragEvent(it, DragEvent.DRAG_OVER) }
        node.onDragOver.handle(fakeDragEventOf(DragEvent.DRAG_OVER))
    }

    @Test fun onDragDropped() {
        node.callOnDragDropped { assertFakeDragEvent(it, DragEvent.DRAG_DROPPED) }
        node.onDragDropped.handle(fakeDragEventOf(DragEvent.DRAG_DROPPED))
    }

    @Test fun onDragDone() {
        node.callOnDragDone { assertFakeDragEvent(it, DragEvent.DRAG_DONE) }
        node.onDragDone.handle(fakeDragEventOf(DragEvent.DRAG_DONE))
    }

    @Test fun onContextMenuRequested() {
        node.callOnContextMenuRequested {
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
                this, FakeEventTarget, ContextMenuEvent.CONTEXT_MENU_REQUESTED,
                0.0, 0.0, 0.0, 0.0,
                false, FakePickResult
            )
        )
    }

    @Test fun onMouseClicked() {
        node.callOnMouseClicked { assertFakeMouseEvent(it, MouseEvent.MOUSE_CLICKED) }
        node.onMouseClicked.handle(fakeMouseEventOf(MouseEvent.MOUSE_CLICKED))
    }

    @Test fun onMouseDragged() {
        node.callOnMouseDragged { assertFakeMouseEvent(it, MouseEvent.MOUSE_DRAGGED) }
        node.onMouseDragged.handle(fakeMouseEventOf(MouseEvent.MOUSE_DRAGGED))
    }

    @Test fun onMouseEntered() {
        node.callOnMouseEntered { assertFakeMouseEvent(it, MouseEvent.MOUSE_ENTERED) }
        node.onMouseEntered.handle(fakeMouseEventOf(MouseEvent.MOUSE_ENTERED))
    }

    @Test fun onMouseExited() {
        node.callOnMouseExited { assertFakeMouseEvent(it, MouseEvent.MOUSE_EXITED) }
        node.onMouseExited.handle(fakeMouseEventOf(MouseEvent.MOUSE_EXITED))
    }

    @Test fun onMouseMoved() {
        node.callOnMouseMoved { assertFakeMouseEvent(it, MouseEvent.MOUSE_MOVED) }
        node.onMouseMoved.handle(fakeMouseEventOf(MouseEvent.MOUSE_MOVED))
    }

    @Test fun onMousePressed() {
        node.callOnMousePressed { assertFakeMouseEvent(it, MouseEvent.MOUSE_PRESSED) }
        node.onMousePressed.handle(fakeMouseEventOf(MouseEvent.MOUSE_PRESSED))
    }

    @Test fun onMouseReleased() {
        node.callOnMouseReleased { assertFakeMouseEvent(it, MouseEvent.MOUSE_RELEASED) }
        node.onMouseReleased.handle(fakeMouseEventOf(MouseEvent.MOUSE_RELEASED))
    }

    @Test fun onDragDetected() {
        node.callOnDragDetected { assertFakeMouseEvent(it, MouseEvent.DRAG_DETECTED) }
        node.onDragDetected.handle(fakeMouseEventOf(MouseEvent.DRAG_DETECTED))
    }

    @Test fun onMouseDragOver() {
        node.callOnMouseDragOver { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_OVER) }
        node.onMouseDragOver.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_OVER))
    }

    @Test fun onMouseDragReleased() {
        node.callOnMouseDragReleased { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_RELEASED) }
        node.onMouseDragReleased.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_RELEASED))
    }

    @Test fun onMouseDragEntered() {
        node.callOnMouseDragEntered { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_ENTERED) }
        node.onMouseDragEntered.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_ENTERED))
    }

    @Test fun onMouseDragExited() {
        node.callOnMouseDragExited { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_EXITED) }
        node.onMouseDragExited.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_EXITED))
    }

    @Test fun onScrollStarted() {
        node.callOnScrollStarted { assertFakeScrollEvent(it, ScrollEvent.SCROLL_STARTED) }
        node.onScrollStarted.handle(fakeScrollEventOf(ScrollEvent.SCROLL_STARTED))
    }

    @Test fun onScroll() {
        node.callOnScroll { assertFakeScrollEvent(it, ScrollEvent.SCROLL) }
        node.onScroll.handle(fakeScrollEventOf(ScrollEvent.SCROLL))
    }

    @Test fun onScrollFinished() {
        node.callOnScrollFinished { assertFakeScrollEvent(it, ScrollEvent.SCROLL_FINISHED) }
        node.onScrollFinished.handle(fakeScrollEventOf(ScrollEvent.SCROLL_FINISHED))
    }

    @Test fun onRotateStarted() {
        node.callOnRotateStarted { assertFakeRotateEvent(it, RotateEvent.ROTATION_STARTED) }
        node.onRotationStarted.handle(fakeRotateEventOf(RotateEvent.ROTATION_STARTED))
    }

    @Test fun onRotate() {
        node.callOnRotate { assertFakeRotateEvent(it, RotateEvent.ROTATE) }
        node.onRotate.handle(fakeRotateEventOf(RotateEvent.ROTATE))
    }

    @Test fun onRotateFinished() {
        node.callOnRotateFinished { assertFakeRotateEvent(it, RotateEvent.ROTATION_FINISHED) }
        node.onRotationFinished.handle(fakeRotateEventOf(RotateEvent.ROTATION_FINISHED))
    }

    @Test fun onZoomStarted() {
        node.callOnZoomStarted { assertFakeZoomEvent(it, ZoomEvent.ZOOM_STARTED) }
        node.onZoomStarted.handle(fakeZoomEventOf(ZoomEvent.ZOOM_STARTED))
    }

    @Test fun onZoom() {
        node.callOnZoom { assertFakeZoomEvent(it, ZoomEvent.ZOOM) }
        node.onZoom.handle(fakeZoomEventOf(ZoomEvent.ZOOM))
    }

    @Test fun onZoomFinished() {
        node.callOnZoomFinished { assertFakeZoomEvent(it, ZoomEvent.ZOOM_FINISHED) }
        node.onZoomFinished.handle(fakeZoomEventOf(ZoomEvent.ZOOM_FINISHED))
    }

    @Test fun onSwipeUp() {
        node.callOnSwipeUp { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_UP) }
        node.onSwipeUp.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_UP))
    }

    @Test fun onSwipeDown() {
        node.callOnSwipeDown { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_DOWN) }
        node.onSwipeDown.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_DOWN))
    }

    @Test fun onSwipeRight() {
        node.callOnSwipeRight { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_RIGHT) }
        node.onSwipeRight.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_RIGHT))
    }

    @Test fun onSwipeLeft() {
        node.callOnSwipeLeft { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_LEFT) }
        node.onSwipeLeft.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_LEFT))
    }

    @Test fun onTouchPressed() {
        node.callOnTouchPressed { assertFakeTouchEvent(it, TouchEvent.TOUCH_PRESSED) }
        node.onTouchPressed.handle(fakeTouchEventOf(TouchEvent.TOUCH_PRESSED))
    }

    @Test fun onTouchMoved() {
        node.callOnTouchMoved { assertFakeTouchEvent(it, TouchEvent.TOUCH_MOVED) }
        node.onTouchMoved.handle(fakeTouchEventOf(TouchEvent.TOUCH_MOVED))
    }

    @Test fun onTouchReleased() {
        node.callOnTouchReleased { assertFakeTouchEvent(it, TouchEvent.TOUCH_RELEASED) }
        node.onTouchReleased.handle(fakeTouchEventOf(TouchEvent.TOUCH_RELEASED))
    }

    @Test fun onTouchStationary() {
        node.callOnTouchStationary { assertFakeTouchEvent(it, TouchEvent.TOUCH_STATIONARY) }
        node.onTouchStationary.handle(fakeTouchEventOf(TouchEvent.TOUCH_STATIONARY))
    }

    @Test fun onKeyPressed() {
        node.callOnKeyPressed { assertFakeKeyEvent(it, KeyEvent.KEY_PRESSED) }
        node.onKeyPressed.handle(fakeKeyEventOf(KeyEvent.KEY_PRESSED))
    }

    @Test fun onKeyReleased() {
        node.callOnKeyReleased { assertFakeKeyEvent(it, KeyEvent.KEY_RELEASED) }
        node.onKeyReleased.handle(fakeKeyEventOf(KeyEvent.KEY_RELEASED))
    }

    @Test fun onKeyTyped() {
        node.callOnKeyTyped { assertFakeKeyEvent(it, KeyEvent.KEY_TYPED) }
        node.onKeyTyped.handle(fakeKeyEventOf(KeyEvent.KEY_TYPED))
    }

    @Test fun onInputMethodTextChanged() {
        node.callOnInputMethodTextChanged {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(InputMethodEvent.INPUT_METHOD_TEXT_CHANGED, it.eventType)
            assertThat(it.composed).isEmpty()
            assertEquals("Hello world", it.committed)
            assertEquals(0, it.caretPosition)
        }
        node.onInputMethodTextChanged.handle(
            InputMethodEvent(
                this, FakeEventTarget, InputMethodEvent.INPUT_METHOD_TEXT_CHANGED,
                listOf(), "Hello world", 0
            )
        )
    }
}