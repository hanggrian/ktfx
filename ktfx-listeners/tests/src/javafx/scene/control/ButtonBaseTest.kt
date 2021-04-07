package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase
import com.hendraanggrian.ktfx.test.BaseButtonBaseTest

class ButtonBaseTest : BaseButtonBaseTest() {

    override fun ButtonBase.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
}