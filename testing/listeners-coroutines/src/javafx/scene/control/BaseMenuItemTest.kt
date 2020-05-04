package com.hendraanggrian.ktfx.test

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseMenuItemTest {
    private lateinit var item: MenuItem

    abstract fun MenuItem.callOnAction(action: (ActionEvent) -> Unit)
    abstract fun MenuItem.callOnMenuValidation(action: (Event) -> Unit)

    @BeforeTest fun start() {
        initToolkit()
        item = MenuItem()
    }

    @Test fun onAction() {
        item.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        item.onAction.handle(ActionEvent(this, FakeEventTarget))
    }

    @Test fun onMenuValidation() {
        item.callOnMenuValidation {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
            assertEquals(Event.ANY, it.eventType)
        }
        item.onMenuValidation.handle(Event(this, FakeEventTarget, Event.ANY))
    }
}