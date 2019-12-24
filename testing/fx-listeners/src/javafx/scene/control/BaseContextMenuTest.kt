package ktfx.test

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlin.test.Test
import kotlin.test.assertEquals

abstract class BaseContextMenuTest : ToolkitInitializer {

    abstract fun ContextMenu.callOnAction(action: (ActionEvent) -> Unit)

    @Test fun onAction() {
        val menu = ContextMenu()
        menu.callOnAction {
            assertEquals(this, it.source)
            assertEquals(FakeEventTarget, it.target)
        }
        menu.onAction.handle(ActionEvent(this, FakeEventTarget))
    }
}