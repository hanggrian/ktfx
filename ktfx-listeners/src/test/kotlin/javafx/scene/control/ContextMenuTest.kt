package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseContextMenuTest
import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu

class ContextMenuTest : BaseContextMenuTest() {
    override fun ContextMenu.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
}
