package ktfx.coroutines

import javafx.event.Event
import javafx.scene.control.Tab
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseTabTest

class TabTest : BaseTabTest() {

    override fun Tab.callOnSelectionChanged(action: (Event) -> Unit) =
        onSelectionChanged(Dispatchers.Unconfined) { action(it) }

    override fun Tab.callOnClosed(action: (Event) -> Unit) =
        onClosed(Dispatchers.Unconfined) { action(it) }

    override fun Tab.callOnCloseRequest(action: (Event) -> Unit) =
        onCloseRequest(Dispatchers.Unconfined) { action(it) }
}