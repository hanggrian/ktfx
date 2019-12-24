package ktfx.test

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseTextFieldTest : ToolkitInitializer {

    abstract fun TextField.callOnAction(action: (ActionEvent) -> Unit)

    @Test fun onAction() {
        val field = TextField()
        field.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        field.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}