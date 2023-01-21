package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseMenuTest
import javafx.event.Event
import javafx.scene.control.Menu

class MenuTest : BaseMenuTest() {
    override fun Menu.callOnShowing(action: (Event) -> Unit) = onShowing(action)
    override fun Menu.callOnShown(action: (Event) -> Unit) = onShown(action)
    override fun Menu.callOnHiding(action: (Event) -> Unit) = onHiding(action)
    override fun Menu.callOnHidden(action: (Event) -> Unit) = onHidden(action)
}
