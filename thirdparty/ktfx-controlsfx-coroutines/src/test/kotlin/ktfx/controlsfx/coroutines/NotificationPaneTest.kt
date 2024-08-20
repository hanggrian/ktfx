package ktfx.controlsfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.Event
import javafx.stage.Stage
import org.controlsfx.control.NotificationPane
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class NotificationPaneTest : ApplicationTest() {
    private lateinit var pane: NotificationPane

    override fun start(stage: Stage) {
        stage.testScene<NotificationPane>()
        pane = NotificationPane()
    }

    @Test
    fun onShowing() {
        interact {
            pane.onShowing {
                assertEquals(this@NotificationPaneTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            pane.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onShown() {
        interact {
            pane.onShown {
                assertEquals(this@NotificationPaneTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            pane.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHiding() {
        interact {
            pane.onHiding {
                assertEquals(this@NotificationPaneTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            pane.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onHidden() {
        interact {
            pane.onHidden {
                assertEquals(this@NotificationPaneTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            pane.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }
}
