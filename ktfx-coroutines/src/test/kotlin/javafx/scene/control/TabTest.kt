package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.testScene
import javafx.event.Event
import javafx.scene.control.Tab
import javafx.stage.Stage
import org.testfx.framework.junit.ApplicationTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TabTest : ApplicationTest() {
    private lateinit var tab: Tab

    override fun start(stage: Stage) {
        stage.testScene<Tab>()
        tab = Tab()
    }

    @Test
    fun onSelectionChanged() {
        interact {
            tab.onSelectionChanged {
                assertEquals(this@TabTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            tab.onSelectionChanged.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onClosed() {
        interact {
            tab.onClosed {
                assertEquals(this@TabTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            tab.onClosed.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }

    @Test
    fun onCloseRequest() {
        interact {
            tab.onCloseRequest {
                assertEquals(this@TabTest, it.source)
                assertEquals(FakeEventTarget, it.target)
                assertEquals(Event.ANY, it.eventType)
            }
            tab.onCloseRequest.handle(Event(this, FakeEventTarget, Event.ANY))
        }
    }
}
