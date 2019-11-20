package ktfx.controlsfx

import javafx.scene.control.TextField
import javafx.stage.Stage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.javafx.JavaFx
import kotlinx.coroutines.runBlocking
import ktfx.layouts.scene
import ktfx.layouts.textField
import ktfx.runLater
import ktfx.testing.AppTest
import org.controlsfx.validation.ValidationSupport
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ValidationSupportTest : AppTest() {

    private lateinit var support: ValidationSupport
    private lateinit var textField: TextField

    override fun start(stage: Stage) {
        support = ValidationSupport()
        stage.scene { textField = textField() }
        stage.show()
    }

    @Test fun registerEmptyValidator() {
        textField.registerEmptyValidator<String>("", support = support)
        assertEquals(support.registeredControls.size, 1)
        runBlocking(Dispatchers.JavaFx) { textField.clear() }
        runLater { assertTrue(support.isInvalid) }
        runBlocking(Dispatchers.JavaFx) { textField.text = "Hello world" }
        runLater { assertFalse(support.isInvalid) }
    }

    @Test fun registerEqualsValidator() {
        textField.registerEqualsValidator("", listOf("Hello", "world"), support = support)
        assertEquals(support.registeredControls.size, 1)
        runBlocking(Dispatchers.JavaFx) { textField.clear() }
        runLater { assertTrue(support.isInvalid) }
        runBlocking(Dispatchers.JavaFx) { textField.text = "Hello" }
        runLater { assertFalse(support.isInvalid) }
    }

    @Test fun registerPredicateValidator() {
        textField.registerPredicateValidator<String>("", support = support) { it.toIntOrNull() != null }
        assertEquals(support.registeredControls.size, 1)
        runBlocking(Dispatchers.JavaFx) { textField.clear() }
        runLater { assertTrue(support.isInvalid) }
        runBlocking(Dispatchers.JavaFx) { textField.text = "123" }
        runLater { assertFalse(support.isInvalid) }
    }
}