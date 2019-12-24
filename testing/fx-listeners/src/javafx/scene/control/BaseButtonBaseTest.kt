package ktfx.test

import javafx.event.ActionEvent
import javafx.scene.control.Button
import javafx.scene.control.ButtonBase
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseButtonBaseTest : ToolkitInitializer {

    abstract fun ButtonBase.callOnAction(action: (ActionEvent) -> Unit)

    @Test fun onAction() {
        val button = Button()
        button.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        button.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}