package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseMenuItemTest

class MenuItemTest : BaseMenuItemTest() {

    override fun MenuItem.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }

    override fun MenuItem.callOnMenuValidation(action: (Event) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }
}