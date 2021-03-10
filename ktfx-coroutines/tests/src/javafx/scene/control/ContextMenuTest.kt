package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.ContextMenu
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseContextMenuTest

class ContextMenuTest : BaseContextMenuTest() {

    override fun ContextMenu.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }
}