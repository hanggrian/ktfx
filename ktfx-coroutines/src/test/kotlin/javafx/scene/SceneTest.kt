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
import com.hanggrian.ktfx.test.testScene
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
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class SceneTest : ApplicationTest() {
    private lateinit var scene: Scene

    override fun start(stage: Stage) {
        stage.testScene<Scene>()
        scene = Scene(Pane())
    }

    @Test
    fun onMouseClicked() {
        interact {
            scene.onMouseClicked {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.MOUSE_CLICKED)
            }
            scene.onMouseClicked.handle(fakeMouseEventOf(MouseEvent.MOUSE_CLICKED))
        }
    }

    @Test
    fun onMouseDragged() {
        interact {
            scene.onMouseDragged {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.MOUSE_DRAGGED)
            }
            scene.onMouseDragged.handle(fakeMouseEventOf(MouseEvent.MOUSE_DRAGGED))
        }
    }

    @Test
    fun onMouseEntered() {
        interact {
            scene.onMouseEntered {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.MOUSE_ENTERED)
            }
            scene.onMouseEntered.handle(fakeMouseEventOf(MouseEvent.MOUSE_ENTERED))
        }
    }

    @Test
    fun onMouseExited() {
        interact {
            scene.onMouseExited {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.MOUSE_EXITED)
            }
            scene.onMouseExited.handle(fakeMouseEventOf(MouseEvent.MOUSE_EXITED))
        }
    }

    @Test
    fun onMouseMoved() {
        interact {
            scene.onMouseMoved {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.MOUSE_MOVED)
            }
            scene.onMouseMoved.handle(fakeMouseEventOf(MouseEvent.MOUSE_MOVED))
        }
    }

    @Test
    fun onMousePressed() {
        interact {
            scene.onMousePressed {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.MOUSE_PRESSED)
            }
            scene.onMousePressed.handle(fakeMouseEventOf(MouseEvent.MOUSE_PRESSED))
        }
    }

    @Test
    fun onMouseReleased() {
        interact {
            scene.onMouseReleased {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.MOUSE_RELEASED)
            }
            scene.onMouseReleased.handle(fakeMouseEventOf(MouseEvent.MOUSE_RELEASED))
        }
    }

    @Test
    fun onDragDetected() {
        interact {
            scene.onDragDetected {
                this@SceneTest.assertFakeMouseEvent(it, MouseEvent.DRAG_DETECTED)
            }
            scene.onDragDetected.handle(fakeMouseEventOf(MouseEvent.DRAG_DETECTED))
        }
    }

    @Test
    fun onMouseDragOver() {
        interact {
            scene.onMouseDragOver {
                this@SceneTest.assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_OVER)
            }
            scene.onMouseDragOver.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_OVER))
        }
    }

    @Test
    fun onMouseDragReleased() {
        interact {
            scene.onMouseDragReleased {
                this@SceneTest.assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_RELEASED)
            }
            scene.onMouseDragReleased
                .handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_RELEASED))
        }
    }

    @Test
    fun onMouseDragEntered() {
        interact {
            scene.onMouseDragEntered {
                this@SceneTest.assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_ENTERED)
            }
            scene.onMouseDragEntered.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_ENTERED))
        }
    }

    @Test
    fun onMouseDragExited() {
        interact {
            scene.onMouseDragExited {
                this@SceneTest.assertFakeMouseDragEvent(it, MouseDragEvent.MOUSE_DRAG_EXITED)
            }
            scene.onMouseDragExited.handle(fakeMouseDragEventOf(MouseDragEvent.MOUSE_DRAG_EXITED))
        }
    }

    @Test
    fun onScrollStarted() {
        interact {
            scene.onScrollStarted {
                this@SceneTest.assertFakeScrollEvent(it, ScrollEvent.SCROLL_STARTED)
            }
            scene.onScrollStarted.handle(fakeScrollEventOf(ScrollEvent.SCROLL_STARTED))
        }
    }

    @Test
    fun onScroll() {
        interact {
            scene.onScroll {
                this@SceneTest.assertFakeScrollEvent(it, ScrollEvent.SCROLL)
            }
            scene.onScroll.handle(fakeScrollEventOf(ScrollEvent.SCROLL))
        }
    }

    @Test
    fun onScrollFinished() {
        interact {
            scene.onScrollFinished {
                this@SceneTest.assertFakeScrollEvent(it, ScrollEvent.SCROLL_FINISHED)
            }
            scene.onScrollFinished.handle(fakeScrollEventOf(ScrollEvent.SCROLL_FINISHED))
        }
    }

    @Test
    fun onRotateStarted() {
        interact {
            scene.onRotationStarted {
                this@SceneTest.assertFakeRotateEvent(it, RotateEvent.ROTATION_STARTED)
            }
            scene.onRotationStarted.handle(fakeRotateEventOf(RotateEvent.ROTATION_STARTED))
        }
    }

    @Test
    fun onRotate() {
        interact {
            scene.onRotate {
                this@SceneTest.assertFakeRotateEvent(it, RotateEvent.ROTATE)
            }
            scene.onRotate.handle(fakeRotateEventOf(RotateEvent.ROTATE))
        }
    }

    @Test
    fun onRotateFinished() {
        interact {
            scene.onRotationFinished {
                this@SceneTest.assertFakeRotateEvent(it, RotateEvent.ROTATION_FINISHED)
            }
            scene.onRotationFinished.handle(fakeRotateEventOf(RotateEvent.ROTATION_FINISHED))
        }
    }

    @Test
    fun onZoomStarted() {
        interact {
            scene.onZoomStarted {
                this@SceneTest.assertFakeZoomEvent(it, ZoomEvent.ZOOM_STARTED)
            }
            scene.onZoomStarted.handle(fakeZoomEventOf(ZoomEvent.ZOOM_STARTED))
        }
    }

    @Test
    fun onZoom() {
        interact {
            scene.onZoom {
                this@SceneTest.assertFakeZoomEvent(it, ZoomEvent.ZOOM)
            }
            scene.onZoom.handle(fakeZoomEventOf(ZoomEvent.ZOOM))
        }
    }

    @Test
    fun onZoomFinished() {
        interact {
            scene.onZoomFinished {
                this@SceneTest.assertFakeZoomEvent(it, ZoomEvent.ZOOM_FINISHED)
            }
            scene.onZoomFinished.handle(fakeZoomEventOf(ZoomEvent.ZOOM_FINISHED))
        }
    }

    @Test
    fun onSwipeUp() {
        interact {
            scene.onSwipeUp {
                this@SceneTest.assertFakeSwipeEvent(it, SwipeEvent.SWIPE_UP)
            }
            scene.onSwipeUp.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_UP))
        }
    }

    @Test
    fun onSwipeDown() {
        interact {
            scene.onSwipeDown {
                this@SceneTest.assertFakeSwipeEvent(it, SwipeEvent.SWIPE_DOWN)
            }
            scene.onSwipeDown.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_DOWN))
        }
    }

    @Test
    fun onSwipeRight() {
        interact {
            scene.onSwipeRight {
                this@SceneTest.assertFakeSwipeEvent(it, SwipeEvent.SWIPE_RIGHT)
            }
            scene.onSwipeRight.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_RIGHT))
        }
    }

    @Test
    fun onSwipeLeft() {
        interact {
            scene.onSwipeLeft {
                this@SceneTest.assertFakeSwipeEvent(it, SwipeEvent.SWIPE_LEFT)
            }
            scene.onSwipeLeft.handle(fakeSwipeEventOf(SwipeEvent.SWIPE_LEFT))
        }
    }

    @Test
    fun onTouchPressed() {
        interact {
            scene.onTouchPressed {
                this@SceneTest.assertFakeTouchEvent(it, TouchEvent.TOUCH_PRESSED)
            }
            scene.onTouchPressed.handle(fakeTouchEventOf(TouchEvent.TOUCH_PRESSED))
        }
    }

    @Test
    fun onTouchMoved() {
        interact {
            scene.onTouchMoved {
                this@SceneTest.assertFakeTouchEvent(it, TouchEvent.TOUCH_MOVED)
            }
            scene.onTouchMoved.handle(fakeTouchEventOf(TouchEvent.TOUCH_MOVED))
        }
    }

    @Test
    fun onTouchReleased() {
        interact {
            scene.onTouchReleased {
                this@SceneTest.assertFakeTouchEvent(it, TouchEvent.TOUCH_RELEASED)
            }
            scene.onTouchReleased.handle(fakeTouchEventOf(TouchEvent.TOUCH_RELEASED))
        }
    }

    @Test
    fun onTouchStationary() {
        interact {
            scene.onTouchStationary {
                this@SceneTest.assertFakeTouchEvent(it, TouchEvent.TOUCH_STATIONARY)
            }
            scene.onTouchStationary.handle(fakeTouchEventOf(TouchEvent.TOUCH_STATIONARY))
        }
    }

    @Test
    fun onDragEntered() {
        interact {
            scene.onDragEntered {
                this@SceneTest.assertFakeDragEvent(it, DragEvent.DRAG_ENTERED)
            }
            scene.onDragEntered.handle(fakeDragEventOf(DragEvent.DRAG_ENTERED))
        }
    }

    @Test
    fun onDragExited() {
        interact {
            scene.onDragExited {
                this@SceneTest.assertFakeDragEvent(it, DragEvent.DRAG_EXITED)
            }
            scene.onDragExited.handle(fakeDragEventOf(DragEvent.DRAG_EXITED))
        }
    }

    @Test
    fun onDragOver() {
        interact {
            scene.onDragOver {
                this@SceneTest.assertFakeDragEvent(it, DragEvent.DRAG_OVER)
            }
            scene.onDragOver.handle(fakeDragEventOf(DragEvent.DRAG_OVER))
        }
    }

    @Test
    fun onDragDropped() {
        interact {
            scene.onDragDropped {
                this@SceneTest.assertFakeDragEvent(it, DragEvent.DRAG_DROPPED)
            }
            scene.onDragDropped.handle(fakeDragEventOf(DragEvent.DRAG_DROPPED))
        }
    }

    @Test
    fun onDragDone() {
        interact {
            scene.onDragDone {
                this@SceneTest.assertFakeDragEvent(it, DragEvent.DRAG_DONE)
            }
            scene.onDragDone.handle(fakeDragEventOf(DragEvent.DRAG_DONE))
        }
    }

    @Test
    fun onKeyPressed() {
        interact {
            scene.onKeyPressed {
                this@SceneTest.assertFakeKeyEvent(it, KeyEvent.KEY_PRESSED)
            }
            scene.onKeyPressed.handle(fakeKeyEventOf(KeyEvent.KEY_PRESSED))
        }
    }

    @Test
    fun onKeyReleased() {
        interact {
            scene.onKeyReleased {
                this@SceneTest.assertFakeKeyEvent(it, KeyEvent.KEY_RELEASED)
            }
            scene.onKeyReleased.handle(fakeKeyEventOf(KeyEvent.KEY_RELEASED))
        }
    }

    @Test
    fun onKeyTyped() {
        interact {
            scene.onKeyTyped {
                this@SceneTest.assertFakeKeyEvent(it, KeyEvent.KEY_TYPED)
            }
            scene.onKeyTyped.handle(fakeKeyEventOf(KeyEvent.KEY_TYPED))
        }
    }

    @Test
    fun onInputMethodTextChanged() {
        interact {
            scene.onInputMethodTextChanged {
                assertEquals(this@SceneTest, it.source)
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
    }

    @Test
    fun onContextMenuRequested() {
        interact {
            scene.onContextMenuRequested {
                assertEquals(this@SceneTest, it.source)
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
}
