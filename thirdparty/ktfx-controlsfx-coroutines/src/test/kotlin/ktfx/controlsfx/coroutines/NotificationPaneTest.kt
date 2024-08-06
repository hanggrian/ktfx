package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.Event
import kotlinx.coroutines.Dispatchers
import org.controlsfx.control.NotificationPane
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class NotificationPaneTest {
    private lateinit var pane: NotificationPane

    @BeforeTest
    fun start() {
        initToolkit()
        pane = NotificationPane()
    }

    @Test
    fun onShowing() {
        pane.onShowing(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onShown() {
        pane.onShown(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHiding() {
        pane.onHiding(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHidden() {
        pane.onHidden(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
