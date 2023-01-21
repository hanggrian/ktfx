package ktfx.coroutines

import com.hendraanggrian.ktfx.test.BaseTextFieldTest
import javafx.event.ActionEvent
import javafx.scene.control.TextField
import kotlinx.coroutines.Dispatchers

class TextFieldTest : BaseTextFieldTest() {
    override fun TextField.callOnAction(action: (ActionEvent) -> Unit) =
        onAction(Dispatchers.Unconfined) { action(it) }
}
