package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseMenuItemTest
import javafx.event.ActionEvent
import javafx.event.Event
import javafx.scene.control.MenuItem

class MenuItemTest : BaseMenuItemTest() {
    override fun MenuItem.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
    override fun MenuItem.callOnMenuValidation(action: (Event) -> Unit) = onMenuValidation(action)
}
