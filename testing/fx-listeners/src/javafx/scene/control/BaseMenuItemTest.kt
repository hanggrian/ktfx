package ktfx.test

import com.sun.javafx.application.PlatformImpl
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseMenuItemTest : ToolkitInitializer {

    abstract fun MenuItem.callOnAction(action: (ActionEvent) -> Unit)
    abstract fun MenuItem.callOnMenuValidation(action: (Event) -> Unit)

    private lateinit var item: MenuItem

    @BeforeTest fun start() {
        PlatformImpl.startup { }
        item = MenuItem()
    }

    @Test fun onAction() {
        item.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        item.onAction.handle(ActionEvent(this, FakeEventTarget))
    }

    @Test fun onMenuValidation() {
        item.callOnMenuValidation {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        item.onMenuValidation.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}