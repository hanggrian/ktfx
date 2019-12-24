package ktfx.test

import com.sun.javafx.application.PlatformImpl
import javafx.event.Event
import javafx.scene.control.Menu
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseMenuTest {

    abstract fun Menu.callOnShowing(action: (Event) -> Unit)
    abstract fun Menu.callOnShown(action: (Event) -> Unit)
    abstract fun Menu.callOnHiding(action: (Event) -> Unit)
    abstract fun Menu.callOnHidden(action: (Event) -> Unit)

    private lateinit var menu: Menu

    @BeforeTest fun start() {
        PlatformImpl.startup { }
        menu = Menu()
    }

    @Test fun onShowing() {
        menu.callOnShowing {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onShown() {
        menu.callOnShown {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onHiding() {
        menu.callOnHiding {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onHidden() {
        menu.callOnHidden {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}