package ktfx.listeners

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import io.github.hendraanggrian.ktfx.test.BaseTextFieldTest

class TextFieldTest : BaseTextFieldTest() {

    override fun TextField.callOnAction(action: (ActionEvent) -> Unit) = onAction(action)
}