package ktfx.test

import com.sun.javafx.application.PlatformImpl
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.DragEvent
import javafx.scene.input.InputMethodEvent
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseDragEvent
import javafx.scene.input.MouseEvent
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

abstract class BaseNodeTest {
    private lateinit var label: Label

    abstract fun Node.callOnDragEntered(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragExited(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragOver(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragDropped(action: (DragEvent) -> Unit)
    abstract fun Node.callOnDragDone(action: (DragEvent) -> Unit)

    abstract fun Node.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit)

    abstract fun Node.callOnDragDetected(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnInputMethodTextChanged(action: (InputMethodEvent) -> Unit)
    abstract fun Node.callOnKeyPressed(action: (KeyEvent) -> Unit)
    abstract fun Node.callOnKeyReleased(action: (KeyEvent) -> Unit)
    abstract fun Node.callOnKeyTyped(action: (KeyEvent) -> Unit)
    abstract fun Node.callOnMouseClicked(action: (MouseEvent) -> Unit)
    abstract fun Node.callOnMouseDragEntered(action: (MouseDragEvent) -> Unit)
    abstract fun Node.callOnMouseDragExited(action: (MouseDragEvent) -> Unit)

    @BeforeTest fun onCreate() {
        PlatformImpl.startup { }
        label = Label()
    }

    @Test fun onContextMenuRequested() {
        label.callOnContextMenuRequested {
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
        label.onContextMenuRequested.handle(
            ContextMenuEvent(
                this, FakeEventTarget, ContextMenuEvent.CONTEXT_MENU_REQUESTED,
                0.0, 0.0, 0.0, 0.0,
                false, FakePickResult
            )
        )
    }

    @Test fun onDragDetected() {
        label.callOnDragDetected { assertFakeMouseEvent(this, it, MouseEvent.MOUSE_CLICKED) }
        label.onDragDetected.handle(fakeMouseEventOf(this, MouseEvent.MOUSE_CLICKED))
    }

    @Test fun onDragDone() {
        label.callOnDragDone { assertFakeDragEvent(this, it, DragEvent.DRAG_DONE) }
        label.onDragDone.handle(fakeDragEventOf(this, DragEvent.DRAG_DONE))
    }

    @Test fun onDragDropped() {
        label.callOnDragDropped { assertFakeDragEvent(this, it, DragEvent.DRAG_DROPPED) }
        label.onDragDropped.handle(fakeDragEventOf(this, DragEvent.DRAG_DROPPED))
    }

    @Test fun onDragEntered() {
        label.callOnDragEntered { assertFakeDragEvent(this, it, DragEvent.DRAG_ENTERED) }
        label.onDragEntered.handle(fakeDragEventOf(this, DragEvent.DRAG_ENTERED))
    }

    @Test fun onDragExited() {
        label.callOnDragExited { assertFakeDragEvent(this, it, DragEvent.DRAG_EXITED) }
        label.onDragExited.handle(fakeDragEventOf(this, DragEvent.DRAG_EXITED))
    }

    @Test fun onDragOver() {
        label.callOnDragOver { assertFakeDragEvent(this, it, DragEvent.DRAG_OVER) }
        label.onDragOver.handle(fakeDragEventOf(this, DragEvent.DRAG_OVER))
    }

    @Test fun onInputMethodTextChanged() {
        label.callOnInputMethodTextChanged {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(InputMethodEvent.INPUT_METHOD_TEXT_CHANGED, it.eventType)
            assertEmpty(it.composed)
            assertEquals("Hello world", it.committed)
            assertEquals(0, it.caretPosition)
        }
        label.onInputMethodTextChanged.handle(
            InputMethodEvent(
                this, FakeEventTarget, InputMethodEvent.INPUT_METHOD_TEXT_CHANGED,
                listOf(), "Hello world", 0
            )
        )
    }

    @Test fun onKeyPressed() {
        label.callOnKeyPressed { assertFakeKeyEvent(this, it, KeyEvent.KEY_PRESSED) }
        label.onKeyPressed.handle(fakeKeyEventOf(this, KeyEvent.KEY_PRESSED))
    }

    @Test fun onKeyReleased() {
        label.callOnKeyReleased { assertFakeKeyEvent(this, it, KeyEvent.KEY_RELEASED) }
        label.onKeyReleased.handle(fakeKeyEventOf(this, KeyEvent.KEY_RELEASED))
    }

    @Test fun onKeyTyped() {
        label.callOnKeyTyped { assertFakeKeyEvent(this, it, KeyEvent.KEY_TYPED) }
        label.onKeyTyped.handle(fakeKeyEventOf(this, KeyEvent.KEY_TYPED))
    }

    @Test fun onMouseClicked() {
        label.callOnMouseClicked { assertFakeMouseEvent(this, it, MouseEvent.MOUSE_CLICKED) }
        label.onMouseClicked.handle(fakeMouseEventOf(this, MouseEvent.MOUSE_CLICKED))
    }

    @Test fun onMouseDragEntered() {
        label.callOnMouseDragEntered { assertFakeMouseDragEvent(this, it, MouseDragEvent.MOUSE_DRAG_ENTERED) }
        label.onMouseDragEntered.handle(fakeMouseDragEventOf(this, MouseDragEvent.MOUSE_DRAG_ENTERED))
    }

    @Test fun onMouseDragExited() {
        label.callOnMouseDragExited { assertFakeMouseDragEvent(this, it, MouseDragEvent.MOUSE_DRAG_EXITED) }
        label.onMouseDragExited.handle(fakeMouseDragEventOf(this, MouseDragEvent.MOUSE_DRAG_EXITED))
    }
}