package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseMenuItemTest
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem
import kotlinx.coroutines.Dispatchers

class MenuItemTest : BaseMenuItemTest() {
    override fun MenuItem.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }

    override fun MenuItem.callOnMenuValidation(action: (Event) -> Unit) =
        onMenuValidation(Dispatchers.Unconfined) { action(it) }
}
