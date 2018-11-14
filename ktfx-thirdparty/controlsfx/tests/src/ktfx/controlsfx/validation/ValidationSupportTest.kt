package ktfx.controlsfx.validation

import com.sun.javafx.application.PlatformImpl
import javafx.application.Platform
import javafx.scene.Scene
import javafx.scene.control.TextField
import javafx.stage.Stage
import ktfx.controlsfx.registerEmptyValidator
import ktfx.controlsfx.registerEqualsValidator
import ktfx.controlsfx.registerPredicateValidator
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
        run { assertTrue(support.isInvalid) }
        runAndWait { textField.text = "Hello world" }
        run { assertFalse(support.isInvalid) }
    }

    @Test fun registerEqualsValidator() {
        textField.registerEqualsValidator("", listOf("Hello", "world"), support = support)
        assertEquals(support.registeredControls.size, 1)
        runAndWait { textField.clear() }
        run { assertTrue(support.isInvalid) }
        runAndWait { textField.text = "Hello" }
        run { assertFalse(support.isInvalid) }
    }

    @Test fun registerPredicateValidator() {
        textField.registerPredicateValidator<String>("", support = support) { it.toIntOrNull() != null }
        assertEquals(support.registeredControls.size, 1)
        runAndWait { textField.clear() }
        run { assertTrue(support.isInvalid) }
        runAndWait { textField.text = "123" }
        run { assertFalse(support.isInvalid) }
    }

    private fun run(block: () -> Unit) = Platform.runLater(block)

    private fun runAndWait(block: () -> Unit) = PlatformImpl.runAndWait(block)
}