package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import io.github.hendraanggrian.ktfx.test.BaseContextMenuTest

class ContextMenuTest : BaseContextMenuTest() {

    override fun ContextMenu.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
}