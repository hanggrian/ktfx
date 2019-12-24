package ktfx.listeners

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import ktfx.test.BaseMenuItemTest

class MenuItemTest : BaseMenuItemTest() {

    override fun MenuItem.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
    override fun MenuItem.callOnMenuValidation(action: (Event) -> Unit) = onAction(action)
}