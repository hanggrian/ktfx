package com.hendraanggrian.ktfx.test

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.ComboBox
import javafx.scene.control.ComboBoxBase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseComboBoxBaseTest {
    private lateinit var combo: ComboBoxBase<String>

    abstract fun <E> ComboBoxBase<E>.callOnAction(action: (ActionEvent) -> Unit)
    abstract fun <E> ComboBoxBase<E>.callOnShowing(action: (Event) -> Unit)
    abstract fun <E> ComboBoxBase<E>.callOnShown(action: (Event) -> Unit)
    abstract fun <E> ComboBoxBase<E>.callOnHiding(action: (Event) -> Unit)
    abstract fun <E> ComboBoxBase<E>.callOnHidden(action: (Event) -> Unit)

    @BeforeTest
    fun start() {
        initToolkit()
        combo = ComboBox()
    }

    @Test
    fun onAction() {
        combo.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        combo.onAction.handle(ActionEvent(this, FakeEventTarget))
    }

    @Test
    fun onShowing() {
        combo.callOnShowing {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onShowing.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onShown() {
        combo.callOnShown {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onShown.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHiding() {
        combo.callOnHiding {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onHiding.handle(Event(this, FakeEventTarget, Event.ANY))
    }

    @Test
    fun onHidden() {
        combo.callOnHidden {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        combo.onHidden.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}
