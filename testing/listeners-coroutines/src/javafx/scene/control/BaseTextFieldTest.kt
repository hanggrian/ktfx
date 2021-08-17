package com.hendraanggrian.ktfx.test

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTextFieldTest {

    abstract fun TextField.callOnAction(action: (ActionEvent) -> Unit)

    @BeforeTest fun start() = initToolkit()

    @Test
    fun onAction() {
        val field = TextField()
        field.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        field.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}