package ktfx.controlsfx

import javafx.scene.control.TextField
import javafx.stage.Stage
import ktfx.controlsfx.controls.registerEmptyValidator
import ktfx.controlsfx.controls.registerEqualsValidator
import ktfx.controlsfx.controls.registerPredicateValidator
import ktfx.layouts.scene
import ktfx.layouts.textField
import org.controlsfx.validation.ValidationSupport
import org.junit.jupiter.api.extension.ExtendWith
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@ExtendWith(ApplicationExtension::class)
class ValidationSupportTest {
    private lateinit var support: ValidationSupport
    private lateinit var textField: TextField

    @Start fun start(stage: Stage) {
        support = ValidationSupport()
        stage.scene { textField = textField() }
        stage.show()
    }

    @Test fun FxRobot.registerEmptyValidator() {
        textField.registerEmptyValidator<String>("", support = support)
        assertEquals(1, support.registeredControls.size)
        clickOn(textField)
        assertTrue(support.isInvalid)
        write("Hello world")
        assertFalse(support.isInvalid)
    }

    @Test fun FxRobot.registerEqualsValidator() {
        textField.registerEqualsValidator("", listOf("Hello", "world"), support = support)
        assertEquals(1, support.registeredControls.size)
        clickOn(textField)
        assertTrue(support.isInvalid)
        write("Hello")
        assertFalse(support.isInvalid)
    }

    @Test fun FxRobot.registerPredicateValidator() {
        textField.registerPredicateValidator<String>("", support = support) { it.toIntOrNull() != null }
        assertEquals(1, support.registeredControls.size)
        clickOn(textField)
        assertTrue(support.isInvalid)
        write("123")
        assertFalse(support.isInvalid)
    }
}