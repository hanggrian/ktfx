package ktfx.listeners

import com.hendraanggrian.ktfx.test.BaseTextFieldTest
import javafx.event.ActionEvent
import javafx.scene.control.TextField

class TextFieldTest : BaseTextFieldTest() {
    override fun TextField.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
}
