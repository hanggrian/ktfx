package ktfx.listeners

import javafx.event.Event
import javafx.scene.control.Menu
import ktfx.test.BaseMenuTest

class MenuTest : BaseMenuTest() {

    override fun Menu.callOnShowing(action: (Event) -> Unit) = onShowing(action)
    override fun Menu.callOnShown(action: (Event) -> Unit) = onShown(action)
    override fun Menu.callOnHiding(action: (Event) -> Unit) = onHiding(action)
    override fun Menu.callOnHidden(action: (Event) -> Unit) = onHidden(action)
}