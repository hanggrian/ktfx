package kotfx

import javafx.scene.control.Button
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import kotfx.bindings.lessEq
import kotfx.bindings.neq
import kotfx.bindings.or
import kotfx.controls.textProperty

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
class DialogsTest {

    // @get:Rule
    val rule
        get() = JavaFXThreadingRule()

    // @Test
    fun alert() {
        kotfx.dialogs.alert("")
        kotfx.dialogs.alert("") {}

        kotfx.dialogs.alert("", "")
        kotfx.dialogs.alert("", "") {}

        val textField = TextField()
        val button = Button()

        val passwordField = PasswordField()
        val passwordConfirmField = PasswordField()

        button.disableProperty().bind(passwordField.textProperty.isEmpty
                or passwordConfirmField.textProperty().isEmpty
                or (passwordField.textProperty().length() lessEq 4)
                or (passwordConfirmField.textProperty().length() lessEq 4)
                or (passwordField.textProperty() neq passwordConfirmField.textProperty()))
    }
}