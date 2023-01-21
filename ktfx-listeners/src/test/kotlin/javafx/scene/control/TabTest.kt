package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseTabTest
import javafx.event.Event
import javafx.scene.control.Tab

class TabTest : BaseTabTest() {
    override fun Tab.callOnSelectionChanged(action: (Event) -> Unit) = onSelectionChanged(action)
    override fun Tab.callOnClosed(action: (Event) -> Unit) = onClosed(action)
    override fun Tab.callOnCloseRequest(action: (Event) -> Unit) = onCloseRequest(action)
}
