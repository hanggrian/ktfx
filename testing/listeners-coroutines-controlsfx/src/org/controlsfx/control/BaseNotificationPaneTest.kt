package ktfx.controlsfx.test

import javafx.event.Event
import com.hendraanggrian.ktfx.test.FakeEventTarget
import com.hendraanggrian.ktfx.test.initToolkit
import org.controlsfx.control.NotificationPane
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseNotificationPaneTest {
    private lateinit var pane: NotificationPane

    abstract fun NotificationPane.callOnShowing(action: (Event) -> Unit)
    abstract fun NotificationPane.callOnShown(action: (Event) -> Unit)
    abstract fun NotificationPane.callOnHiding(action: (Event) -> Unit)
    abstract fun NotificationPane.callOnHidden(action: (Event) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        pane = NotificationPane()
    }

    @Test fun onShowing() {
        pane.callOnShowing {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onShown() {
        pane.callOnShown {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onHiding() {
        pane.callOnHiding {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onHidden() {
        pane.callOnHidden {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        pane.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}