package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class MenuItemTest {
    private lateinit var item: MenuItem

    @BeforeTest
    fun start() {
        initToolkit()
        item = MenuItem()
    }

    @Test
    fun onAction() {
        item.onAction(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        item.onAction.handle(ActionEvent(this, FakeEventTarget))
    }

    @Test
    fun onMenuValidation() {
        item.onMenuValidation(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        item.onMenuValidation.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
