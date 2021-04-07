package ktfx.listeners

import javafx.event.Event
import javafx.scene.control.Tab
import com.hendraanggrian.ktfx.test.BaseTabTest

class TabTest : BaseTabTest() {

    override fun Tab.callOnSelectionChanged(action: (Event) -> Unit) = onSelectionChanged(action)
    override fun Tab.callOnClosed(action: (Event) -> Unit) = onClosed(action)
    override fun Tab.callOnCloseRequest(action: (Event) -> Unit) = onCloseRequest(action)
}