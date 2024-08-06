package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBox
import javafx.scene.control.ComboBoxBase
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ComboBoxBaseTest {
    private lateinit var combo: ComboBoxBase<String>

    @BeforeTest
    fun start() {
        initToolkit()
        combo = ComboBox()
    }

    @Test
    fun onAction() {
        combo.onAction(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        combo.onAction.handle(ActionEvent(this, FakeEventTarget))
    }

    @Test
    fun onShowing() {
        combo.onShowing(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onShown() {
        combo.onShown(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHiding() {
        combo.onHiding(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHidden() {
        combo.onHidden(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
