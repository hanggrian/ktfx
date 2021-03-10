package ktfx.coroutines

import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlinx.coroutines.Dispatchers
import io.github.hendraanggrian.ktfx.test.BaseTextFieldTest

class TextFieldTest : BaseTextFieldTest() {

    override fun TextField.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }
}