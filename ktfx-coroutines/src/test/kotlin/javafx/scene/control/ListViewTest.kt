package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.scene.control.ListView
import javafx.scene.control.ScrollToEvent
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ListViewTest {
    private lateinit var control: ListView<String>

    @BeforeTest
    fun start() {
        initToolkit()
        control = ListView()
    }

    @Test
    fun onEditStart() {
        control.onEditStart(Dispatchers.Unconfined) {
            assertEquals(control, it.source)
            assertEquals(ListView.editStartEvent<String>(), it.eventType)
            assertEquals("", it.newValue)
            assertEquals(0, it.index)
        }
        control.onEditStart.handle(ListView.EditEvent(control, ListView.editStartEvent(), "", 0))
    }

    @Test
    fun onEditCommit() {
        control.onEditCommit(Dispatchers.Unconfined) {
            assertEquals(control, it.source)
            assertEquals(ListView.editCommitEvent<String>(), it.eventType)
            assertEquals("", it.newValue)
            assertEquals(0, it.index)
        }
        control.onEditCommit.handle(ListView.EditEvent(control, ListView.editCommitEvent(), "", 0))
    }

    @Test
    fun onEditCancel() {
        control.onEditCancel(Dispatchers.Unconfined) {
            assertEquals(control, it.source)
            assertEquals(ListView.editCancelEvent<String>(), it.eventType)
            assertEquals("", it.newValue)
            assertEquals(0, it.index)
        }
        control.onEditCancel.handle(ListView.EditEvent(control, ListView.editCancelEvent(), "", 0))
    }

    @Test
    fun onScrollTo() {
        control.onScrollTo(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(ScrollToEvent.scrollToTopIndex(), it.eventType)
            assertEquals(0, it.scrollTarget)
        }
        control.onScrollTo
            .handle(ScrollToEvent(this, FakeEventTarget, ScrollToEvent.scrollToTopIndex(), 0))
    }
}
