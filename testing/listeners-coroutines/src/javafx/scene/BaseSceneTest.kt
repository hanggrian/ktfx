package javafx.scene

import com.google.common.truth.Truth.assertThat
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
import io.github.hendraanggrian.ktfx.test.FakeEventTarget
import io.github.hendraanggrian.ktfx.test.FakePickResult
import io.github.hendraanggrian.ktfx.test.assertFakeDragEvent
import io.github.hendraanggrian.ktfx.test.assertFakeKeyEvent
import io.github.hendraanggrian.ktfx.test.assertFakeMouseDragEvent
import io.github.hendraanggrian.ktfx.test.assertFakeMouseEvent
import io.github.hendraanggrian.ktfx.test.assertFakeRotateEvent
import io.github.hendraanggrian.ktfx.test.assertFakeScrollEvent
import io.github.hendraanggrian.ktfx.test.assertFakeSwipeEvent
import io.github.hendraanggrian.ktfx.test.assertFakeTouchEvent
import io.github.hendraanggrian.ktfx.test.assertFakeZoomEvent
import io.github.hendraanggrian.ktfx.test.fakeDragEventOf
import io.github.hendraanggrian.ktfx.test.fakeKeyEventOf
import io.github.hendraanggrian.ktfx.test.fakeMouseDragEventOf
import io.github.hendraanggrian.ktfx.test.fakeMouseEventOf
import io.github.hendraanggrian.ktfx.test.fakeRotateEventOf
import io.github.hendraanggrian.ktfx.test.fakeScrollEventOf
import io.github.hendraanggrian.ktfx.test.fakeSwipeEventOf
import io.github.hendraanggrian.ktfx.test.fakeTouchEventOf
import io.github.hendraanggrian.ktfx.test.fakeZoomEventOf
import io.github.hendraanggrian.ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

abstract class BaseSceneTest {
    private lateinit var scene: Scene

    abstract fun Scene.callOnMouseClicked(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnMouseDragged(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnMouseEntered(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnMouseExited(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnMouseMoved(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnMousePressed(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnMouseReleased(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnDragDetected(action: (MouseEvent) -> Unit)
    abstract fun Scene.callOnMouseDragOver(action: (MouseDragEvent) -> Unit)
    abstract fun Scene.callOnMouseDragReleased(action: (MouseDragEvent) -> Unit)
    abstract fun Scene.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit)
    abstract fun Scene.callOnMouseDragExited(action: (MouseDragEvent) -> Unit)
    abstract fun Scene.callOnScrollStarted(action: (ScrollEvent) -> Unit)
    abstract fun Scene.callOnScroll(action: (ScrollEvent) -> Unit)
    abstract fun Scene.callOnScrollFinished(action: (ScrollEvent) -> Unit)
    abstract fun Scene.callOnRotationStarted(action: (RotateEvent) -> Unit)
    abstract fun Scene.callOnRotate(action: (RotateEvent) -> Unit)
    abstract fun Scene.callOnRotationFinished(action: (RotateEvent) -> Unit)
    abstract fun Scene.callOnZoomStarted(action: (ZoomEvent) -> Unit)
    abstract fun Scene.callOnZoom(action: (ZoomEvent) -> Unit)
    abstract fun Scene.callOnZoomFinished(action: (ZoomEvent) -> Unit)
    abstract fun Scene.callOnSwipeUp(action: (SwipeEvent) -> Unit)
    abstract fun Scene.callOnSwipeDown(action: (SwipeEvent) -> Unit)
    abstract fun Scene.callOnSwipeLeft(action: (SwipeEvent) -> Unit)
    abstract fun Scene.callOnSwipeRight(action: (SwipeEvent) -> Unit)
    abstract fun Scene.callOnTouchPressed(action: (TouchEvent) -> Unit)
    abstract fun Scene.callOnTouchMoved(action: (TouchEvent) -> Unit)
    abstract fun Scene.callOnTouchReleased(action: (TouchEvent) -> Unit)
    abstract fun Scene.callOnTouchStationary(action: (TouchEvent) -> Unit)
    abstract fun Scene.callOnDragEntered(action: (DragEvent) -> Unit)
    abstract fun Scene.callOnDragExited(action: (DragEvent) -> Unit)
    abstract fun Scene.callOnDragOver(action: (DragEvent) -> Unit)
    abstract fun Scene.callOnDragDropped(action: (DragEvent) -> Unit)
    abstract fun Scene.callOnDragDone(action: (DragEvent) -> Unit)
    abstract fun Scene.callOnKeyPressed(action: (KeyEvent) -> Unit)
    abstract fun Scene.callOnKeyReleased(action: (KeyEvent) -> Unit)
    abstract fun Scene.callOnKeyTyped(action: (KeyEvent) -> Unit)
    abstract fun Scene.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit)
    abstract fun Scene.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit)

    @BeforeTest fun onCreate() {
        initToolkit()
        scene = Scene(Pane())
    }

    @Test fun onMouseClicked() {
        scene.callOnMouseClicked { assertFakeMouseEvent(it, MouseEvent.MOUSE_CLICKED) }
        scene.onMouseClicked.handle(fakeMouseEventOf(MouseEvent.MOUSE_CLICKED))
    }

    @Test fun onMouseDragged() {
        scene.callOnMouseDragged { assertFakeMouseEvent(it, MouseEvent.MOUSE_DRAGGED) }
        scene.onMouseDragged.handle(fakeMouseEventOf(MouseEvent.MOUSE_DRAGGED))
    }

    @Test fun onMouseEntered() {
        scene.callOnMouseEntered { assertFakeMouseEvent(it, MouseEvent.MOUSE_ENTERED) }
        scene.onMouseEntered.handle(fakeMouseEventOf(MouseEvent.MOUSE_ENTERED))
    }

    @Test fun onMouseExited() {
        scene.callOnMouseExited { assertFakeMouseEvent(it, MouseEvent.MOUSE_EXITED) }
        scene.onMouseExited.handle(fakeMouseEventOf(MouseEvent.MOUSE_EXITED))
    }

    @Test fun onMouseMoved() {
        scene.callOnMouseMoved { assertFakeMouseEvent(it, MouseEvent.MOUSE_MOVED) }
        scene.onMouseMoved.handle(fakeMouseEventOf(MouseEvent.MOUSE_MOVED))
    }

    @Test fun onMousePressed() {
        scene.callOnMousePressed { assertFakeMouseEvent(it, MouseEvent.MOUSE_PRESSED) }
        scene.onMousePressed.handle(fakeMouseEventOf(MouseEvent.MOUSE_PRESSED))
    }

    @Test fun onMouseReleased() {
        scene.callOnMouseReleased { assertFakeMouseEvent(it, MouseEvent.MOUSE_RELEASED) }
        scene.onMouseReleased.handle(fakeMouseEventOf(MouseEvent.MOUSE_RELEASED))
    }

    @Test fun onDragDetected() {
        scene.callOnDragDetected { assertFakeMouseEvent(it, MouseEvent.DRAG_DETECTED) }
        scene.onDragDetected.handle(fakeMouseEventOf(MouseEvent.DRAG_DETECTED))
    }

    @Test fun onMouseDragOver() {
        scene.callOnMouseDragOver { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_OVER) }
        scene.onMouseDragOver.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_OVER))
    }

    @Test fun onMouseDragReleased() {
        scene.callOnMouseDragReleased { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_RELEASED) }
        scene.onMouseDragReleased.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_RELEASED))
    }

    @Test fun onMouseDragEntered() {
        scene.callOnMouseDragEntered { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_ENTERED) }
        scene.onMouseDragEntered.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_ENTERED))
    }

    @Test fun onMouseDragExited() {
        scene.callOnMouseDragExited { assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_EXITED) }
        scene.onMouseDragExited.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_EXITED))
    }

    @Test fun onScrollStarted() {
        scene.callOnScrollStarted { assertFakeScrollEvent(it, ScrollEvent.SCROLL_STARTED) }
        scene.onScrollStarted.handle(fakeScrollEventOf(ScrollEvent.SCROLL_STARTED))
    }

    @Test fun onScroll() {
        scene.callOnScroll { assertFakeScrollEvent(it, ScrollEvent.SCROLL) }
        scene.onScroll.handle(fakeScrollEventOf(ScrollEvent.SCROLL))
    }

    @Test fun onScrollFinished() {
        scene.callOnScrollFinished { assertFakeScrollEvent(it, ScrollEvent.SCROLL_FINISHED) }
        scene.onScrollFinished.handle(fakeScrollEventOf(ScrollEvent.SCROLL_FINISHED))
    }

    @Test fun onRotateStarted() {
        scene.callOnRotationStarted { assertFakeRotateEvent(it, RotateEvent.ROTATION_STARTED) }
        scene.onRotationStarted.handle(fakeRotateEventOf(RotateEvent.ROTATION_STARTED))
    }

    @Test fun onRotate() {
        scene.callOnRotate { assertFakeRotateEvent(it, RotateEvent.ROTATE) }
        scene.onRotate.handle(fakeRotateEventOf(RotateEvent.ROTATE))
    }

    @Test fun onRotateFinished() {
        scene.callOnRotationFinished { assertFakeRotateEvent(it, RotateEvent.ROTATION_FINISHED) }
        scene.onRotationFinished.handle(fakeRotateEventOf(RotateEvent.ROTATION_FINISHED))
    }

    @Test fun onZoomStarted() {
        scene.callOnZoomStarted { assertFakeZoomEvent(it, ZoomEvent.ZOOM_STARTED) }
        scene.onZoomStarted.handle(fakeZoomEventOf(ZoomEvent.ZOOM_STARTED))
    }

    @Test fun onZoom() {
        scene.callOnZoom { assertFakeZoomEvent(it, ZoomEvent.ZOOM) }
        scene.onZoom.handle(fakeZoomEventOf(ZoomEvent.ZOOM))
    }

    @Test fun onZoomFinished() {
        scene.callOnZoomFinished { assertFakeZoomEvent(it, ZoomEvent.ZOOM_FINISHED) }
        scene.onZoomFinished.handle(fakeZoomEventOf(ZoomEvent.ZOOM_FINISHED))
    }

    @Test fun onSwipeUp() {
        scene.callOnSwipeUp { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_UP) }
        scene.onSwipeUp.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_UP))
    }

    @Test fun onSwipeDown() {
        scene.callOnSwipeDown { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_DOWN) }
        scene.onSwipeDown.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_DOWN))
    }

    @Test fun onSwipeRight() {
        scene.callOnSwipeRight { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_RIGHT) }
        scene.onSwipeRight.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_RIGHT))
    }

    @Test fun onSwipeLeft() {
        scene.callOnSwipeLeft { assertFakeSwipeEvent(it, SwipeEvent.SWIPE_LEFT) }
        scene.onSwipeLeft.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_LEFT))
    }

    @Test fun onTouchPressed() {
        scene.callOnTouchPressed { assertFakeTouchEvent(it, TouchEvent.TOUCH_PRESSED) }
        scene.onTouchPressed.handle(fakeTouchEventOf(TouchEvent.TOUCH_PRESSED))
    }

    @Test fun onTouchMoved() {
        scene.callOnTouchMoved { assertFakeTouchEvent(it, TouchEvent.TOUCH_MOVED) }
        scene.onTouchMoved.handle(fakeTouchEventOf(TouchEvent.TOUCH_MOVED))
    }

    @Test fun onTouchReleased() {
        scene.callOnTouchReleased { assertFakeTouchEvent(it, TouchEvent.TOUCH_RELEASED) }
        scene.onTouchReleased.handle(fakeTouchEventOf(TouchEvent.TOUCH_RELEASED))
    }

    @Test fun onTouchStationary() {
        scene.callOnTouchStationary { assertFakeTouchEvent(it, TouchEvent.TOUCH_STATIONARY) }
        scene.onTouchStationary.handle(fakeTouchEventOf(TouchEvent.TOUCH_STATIONARY))
    }

    @Test fun onDragEntered() {
        scene.callOnDragEntered { assertFakeDragEvent(it, DragEvent.DRAG_ENTERED) }
        scene.onDragEntered.handle(fakeDragEventOf(DragEvent.DRAG_ENTERED))
    }

    @Test fun onDragExited() {
        scene.callOnDragExited { assertFakeDragEvent(it, DragEvent.DRAG_EXITED) }
        scene.onDragExited.handle(fakeDragEventOf(DragEvent.DRAG_EXITED))
    }

    @Test fun onDragOver() {
        scene.callOnDragOver { assertFakeDragEvent(it, DragEvent.DRAG_OVER) }
        scene.onDragOver.handle(fakeDragEventOf(DragEvent.DRAG_OVER))
    }

    @Test fun onDragDropped() {
        scene.callOnDragDropped { assertFakeDragEvent(it, DragEvent.DRAG_DROPPED) }
        scene.onDragDropped.handle(fakeDragEventOf(DragEvent.DRAG_DROPPED))
    }

    @Test fun onDragDone() {
        scene.callOnDragDone { assertFakeDragEvent(it, DragEvent.DRAG_DONE) }
        scene.onDragDone.handle(fakeDragEventOf(DragEvent.DRAG_DONE))
    }

    @Test fun onKeyPressed() {
        scene.callOnKeyPressed { assertFakeKeyEvent(it, KeyEvent.KEY_PRESSED) }
        scene.onKeyPressed.handle(fakeKeyEventOf(KeyEvent.KEY_PRESSED))
    }

    @Test fun onKeyReleased() {
        scene.callOnKeyReleased { assertFakeKeyEvent(it, KeyEvent.KEY_RELEASED) }
        scene.onKeyReleased.handle(fakeKeyEventOf(KeyEvent.KEY_RELEASED))
    }

    @Test fun onKeyTyped() {
        scene.callOnKeyTyped { assertFakeKeyEvent(it, KeyEvent.KEY_TYPED) }
        scene.onKeyTyped.handle(fakeKeyEventOf(KeyEvent.KEY_TYPED))
    }

    @Test fun onInputMethodTextChanged() {
        scene.callOnInputMethodTextChanged {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(InputMethodEvent.INPUT_METHOD_TEXT_CHANGED, it.eventType)
            assertThat(it.composed).isEmpty()
            assertEquals("Hello world", it.committed)
            assertEquals(0, it.caretPosition)
        }
        scene.onInputMethodTextChanged.handle(
            InputMethodEvent(
                this, FakeEventTarget, InputMethodEvent.INPUT_METHOD_TEXT_CHANGED,
                listOf(), "Hello world", 0
            )
        )
    }

    @Test fun onContextMenuRequested() {
        scene.callOnContextMenuRequested {
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
                this, FakeEventTarget, ContextMenuEvent.CONTEXT_MENU_REQUESTED,
                0.0, 0.0, 0.0, 0.0,
                false, FakePickResult
            )
        )
    }
}