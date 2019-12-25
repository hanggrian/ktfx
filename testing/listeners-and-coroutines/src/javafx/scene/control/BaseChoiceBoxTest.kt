package ktfx.test

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ChoiceBox
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseChoiceBoxTest {

    abstract fun <E> ChoiceBox<E>.callOnAction(action: (ActionEvent) -> Unit)
    abstract fun <E> ChoiceBox<E>.callOnShowing(action: (Event) -> Unit)
    abstract fun <E> ChoiceBox<E>.callOnShown(action: (Event) -> Unit)
    abstract fun <E> ChoiceBox<E>.callOnHiding(action: (Event) -> Unit)
    abstract fun <E> ChoiceBox<E>.callOnHidden(action: (Event) -> Unit)

    private lateinit var choice: ChoiceBox<String>

    @BeforeTest fun start() {
        initToolkit()
        choice = ChoiceBox()
    }

    @Test fun onAction() {
        choice.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        choice.onAction.handle(ActionEvent(this, FakeEventTarget))
    }

    @Test fun onShowing() {
        choice.callOnShowing {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onShown() {
        choice.callOnShown {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onHiding() {
        choice.callOnHiding {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onHidden() {
        choice.callOnHidden {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        choice.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}