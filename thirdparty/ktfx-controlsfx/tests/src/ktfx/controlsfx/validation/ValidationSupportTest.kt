package ktfx.controlsfx.validation

import javafx.application.Platform
import javafx.scene.Scene
import javafx.scene.control.TextField
import javafx.stage.Stage
import ktfx.controlsfx.registerEmptyValidator
import ktfx.test.AppTest
import org.controlsfx.validation.ValidationSupport
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidationSupportTest : AppTest() {

    private lateinit var support: ValidationSupport
    private lateinit var textField: TextField

    override fun start(stage: Stage) {
        support = ValidationSupport()
        textField = TextField()
        stage.scene = Scene(textField)
        stage.show()
    }

    @Test fun registerEmptyValidator() {
        textField.registerEmptyValidator<String>("Text is required", support = support)
        assertEquals(support.registeredControls.size, 1)
        textField.clear()
        Platform.runLater { assertTrue(support.isInvalid) }
        textField.text = "Hello world"
        Platform.runLater { assertFalse(support.isInvalid) }
    }
}