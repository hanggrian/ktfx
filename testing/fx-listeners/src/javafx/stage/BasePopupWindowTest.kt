package javafx.stage

import javafx.event.Event
import javafx.scene.control.ContextMenu
import ktfx.test.FakeEventTarget
import ktfx.test.initToolkit
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BasePopupWindowTest {

    abstract fun PopupWindow.callOnAutoHide(action: (Event) -> Unit)

    private lateinit var window: PopupWindow

    @BeforeTest fun start() {
        initToolkit()
        window = ContextMenu()
    }

    @Test fun onAutoHide() {
        window.callOnAutoHide {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        window.onAutoHide.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}