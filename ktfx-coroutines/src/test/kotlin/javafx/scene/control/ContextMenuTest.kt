package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseContextMenuTest
import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlinx.coroutines.Dispatchers

class ContextMenuTest : BaseContextMenuTest() {
    override fun ContextMenu.callOnAction(action: (ActionEvent) -> Unit) {
        onAction(Dispatchers.Unconfined) { action(it) }
    }
}
