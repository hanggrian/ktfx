package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.Event
import javafx.scene.control.Menu
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuTest {
    private lateinit var menu: Menu

    @BeforeTest
    fun start() {
        initToolkit()
        menu = Menu()
    }

    @Test
    fun onShowing() {
        menu.onShowing(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onShown() {
        menu.onShown(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHiding() {
        menu.onHiding(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHidden() {
        menu.onHidden(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        menu.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
