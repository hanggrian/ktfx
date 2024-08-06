package ktfx.coroutines

import com.hanggrian.ktfx.test.FakeEventTarget
import com.hanggrian.ktfx.test.initToolkit
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlinx.coroutines.Dispatchers
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class ChoiceBoxTest {
    private lateinit var choice: ChoiceBox<String>

    @BeforeTest
    fun start() {
        initToolkit()
        choice = ChoiceBox()
    }

    @Test
    fun onAction() {
        choice.onAction(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        choice.onAction.handle(ActionEvent(this, FakeEventTarget))
    }

    @Test
    fun onShowing() {
        choice.onShowing(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onShown() {
        choice.onShown(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHiding() {
        choice.onHiding(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHidden() {
        choice.onHidden(Dispatchers.Unconfined) {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
