package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase
import kotlinx.coroutines.Dispatchers
import ktfx.test.BaseButtonBaseTest

class ButtonBaseTest : BaseButtonBaseTest() {

    override fun ButtonBase.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }
}