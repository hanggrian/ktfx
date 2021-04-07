package com.hendraanggrian.ktfx.test

import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.ButtonBase
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseButtonBaseTest {

    abstract fun ButtonBase.callOnAction(action: (ActionEvent) -> Unit)

    @BeforeTest fun start() = initToolkit()

    @Test fun onAction() {
        val button = Button()
        button.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        button.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}