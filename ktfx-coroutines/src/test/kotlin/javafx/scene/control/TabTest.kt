package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.Event
import javafx.scene.control.Tab
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class TabTest {
    private lateinit var tab: Tab

    @BeforeTest
    fun start() {
        initToolkit()
        tab = Tab()
    }

    @Test
    fun onSelectionChanged() {
        tab.onSelectionChanged(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        tab.onSelectionChanged.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onClosed() {
        tab.onClosed(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        tab.onClosed.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onCloseRequest() {
        tab.onCloseRequest(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        tab.onCloseRequest.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
