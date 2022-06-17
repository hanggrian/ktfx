package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import com.hendraanggrian.ktfx.test.BaseTextFieldTest

class TextFieldTest : BaseTextFieldTest() {

    override fun TextField.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
}
