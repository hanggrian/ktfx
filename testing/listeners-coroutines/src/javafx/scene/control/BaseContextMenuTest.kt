package com.hendraanggrian.ktfx.test

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseContextMenuTest {

    abstract fun ContextMenu.callOnAction(action: (ActionEvent) -> Unit)

    @BeforeTest fun start() = initToolkit()

    @Test fun onAction() {
        val menu = ContextMenu()
        menu.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        menu.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}