package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseButtonBaseTest
import javafx.event.ActionEvent
import javafx.scene.control.ButtonBase

class ButtonBaseTest : BaseButtonBaseTest() {
    override fun ButtonBase.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
}
