package ktfx.test

import com.sun.javafx.application.PlatformImpl
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.input.ContextMenuEvent
import javafx.scene.input.MouseEvent
import javafx.scene.input.PickResult
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

abstract class BaseNodeTest : ToolkitInitializer {
    private lateinit var label: Label

    abstract fun Node.callOnContextMenuRequested(action: (ContextMenuEvent) -> Unit)
    abstract fun Node.callOnDragDetected(action: (MouseEvent) -> Unit)

    @BeforeTest fun onCreate() {
        PlatformImpl.startup { }
        label = Label()
    }

    @Test fun onContextMenuRequested() {
        label.callOnContextMenuRequested {
            assertEquals(this@BaseNodeTest, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ContextMenuEvent.CONTEXT_MENU_REQUESTED, it.eventType)
            assertEquals(0.0, it.x)
            assertEquals(0.0, it.y)
            assertEquals(0.0, it.sceneX)
            assertEquals(0.0, it.sceneY)
            assertFalse(it.isKeyboardTrigger)
        }
        label.onContextMenuRequested.handle(
            ContextMenuEvent(
                this, FakeEventTarget, ContextMenuEvent.CONTEXT_MENU_REQUESTED,
                0.0, 0.0, 0.0, 0.0,
                false, PickResult(FakeEventTarget, 0.0, 0.0)
            )
        )
    }

    /*@Test fun onDragDetected() {
        label.callOnDragDetected {

        }
        label.onDragDetected.handle(MouseEvent())
    }*/
}