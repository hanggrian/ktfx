package io.github.hendraanggrian.ktfx.test

import javafx.event.Event
import javafx.scene.control.Tab
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTabTest {
    private lateinit var tab: Tab

    abstract fun Tab.callOnSelectionChanged(action: (Event) -> Unit)
    abstract fun Tab.callOnClosed(action: (Event) -> Unit)
    abstract fun Tab.callOnCloseRequest(action: (Event) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        tab = Tab()
    }

    @Test fun onSelectionChanged() {
        tab.callOnSelectionChanged {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        tab.onSelectionChanged.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onClosed() {
        tab.callOnClosed {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        tab.onClosed.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test fun onCloseRequest() {
        tab.callOnCloseRequest {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        tab.onCloseRequest.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}