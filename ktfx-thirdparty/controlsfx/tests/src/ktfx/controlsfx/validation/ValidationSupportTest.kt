package ktfx.controlsfx.validation

import javafx.scene.Scene
import javafx.scene.control.TextField
import javafx.stage.Stage
import ktfx.controlsfx.registerEmptyValidator
import ktfx.controlsfx.registerEqualsValidator
import ktfx.controlsfx.registerPredicateValidator
import ktfx.runAndWait
import ktfx.runLater
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
        textField.registerEmptyValidator<String>("", support = support)
        assertEquals(support.registeredControls.size, 1)
        runAndWait { textField.clear() }
        runLater { assertTrue(support.isInvalid) }
        runAndWait { textField.text = "Hello world" }
        runLater { assertFalse(support.isInvalid) }
    }

    @Test fun registerEqualsValidator() {
        textField.registerEqualsValidator("", listOf("Hello", "world"), support = support)
        assertEquals(support.registeredControls.size, 1)
        runAndWait { textField.clear() }
        runLater { assertTrue(support.isInvalid) }
        runAndWait { textField.text = "Hello" }
        runLater { assertFalse(support.isInvalid) }
    }

    @Test fun registerPredicateValidator() {
        textField.registerPredicateValidator<String>("", support = support) { it.toIntOrNull() != null }
        assertEquals(support.registeredControls.size, 1)
        runAndWait { textField.clear() }
        runLater { assertTrue(support.isInvalid) }
        runAndWait { textField.text = "123" }
        runLater { assertFalse(support.isInvalid) }
    }
}